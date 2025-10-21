package com.codeLearner.Ziganya.models.contribution;

import com.codeLearner.Ziganya.exceptionhandling.exception.UnsupportedOperationException;
import com.codeLearner.Ziganya.i18n.I18nConstants;
import com.codeLearner.Ziganya.i18n.I18nConstantsInjectedMessages;
import com.codeLearner.Ziganya.models.associationaccount.AssociationAccount;
import com.codeLearner.Ziganya.models.associationaccount.AssociationAccountRepository;
import com.codeLearner.Ziganya.models.member.Member;
import com.codeLearner.Ziganya.models.member.MemberRepository;
import com.codeLearner.Ziganya.models.settings.AssociationSettings;
import com.codeLearner.Ziganya.models.settings.AssociationSettingsRepository;
import com.codeLearner.Ziganya.util.DeleteOperationResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.util.List;

@Service
public class ContributionServiceImpl implements ContributionService {
    private final ContributionRepository contributionRepository;
    private final ContributionConverter contributionConverter;
    private final AssociationSettingsRepository associationSettingsRepository;
    private final MemberRepository memberRepository;
    private final AssociationAccountRepository associationAccountRepository;

    public ContributionServiceImpl(ContributionRepository contributionRepository, ContributionConverter contributionConverter, AssociationSettingsRepository associationSettingsRepository, MemberRepository memberRepository, AssociationAccountRepository associationAccountRepository) {
        this.contributionRepository = contributionRepository;
        this.contributionConverter = contributionConverter;
        this.associationSettingsRepository = associationSettingsRepository;
        this.memberRepository = memberRepository;
        this.associationAccountRepository = associationAccountRepository;
    }

    @Override
    public ContributionResponse createContribution(ContributionRequest request) {
        AssociationAccount associationAccount = associationAccountRepository.findCurrentAssociationAccount();
        AssociationSettings associationSettings = associationSettingsRepository.fetchCurrentAssociationSettings();
        Member member = memberRepository.findById(request.getMemberId()).orElseThrow(() -> new UnsupportedOperationException(I18nConstantsInjectedMessages.MEMBER_NOT_FOUND_KEY, I18nConstants.MEMBER_NOT_FOUND, I18nConstants.MEMBER_NOT_FOUND));
        Contribution contribution = contributionConverter.convertToEntity(request);
        if (request.getAmount() < (member.getManyOfActions() * associationSettings.getContributionAmount()) || request.getAmount() > (member.getManyOfActions() * associationSettings.getContributionAmount())) {
            throw new UnsupportedOperationException(I18nConstantsInjectedMessages.CONTRIBUTION_AMOUNT_NOT_VALID_KEY, I18nConstants.CONTRIBUTION_AMOUNT_NOT_VALID, I18nConstants.CONTRIBUTION_AMOUNT_NOT_VALID);
        }
        if(request.getMonth().getValue() < LocalDate.now().getMonth().getValue()){
            contribution.setLatePenaltyAmount((request.getAmount()*associationSettings.getLatePaymentPenalityInPercentage())/100);
        }else {
            contribution.setLatePenaltyAmount(0.0);
        }

        Contribution byEmployeeAndMonth = contributionRepository.getContributionByEmployeeIdAndMonth(request.getMemberId(), request.getMonth());
        if (byEmployeeAndMonth != null) {
            throw new UnsupportedOperationException(I18nConstantsInjectedMessages.CONTRIBUTION_ALREADY_EXISTS_KEY, I18nConstants.CONTRIBUTION_ALREADY_EXISTS, I18nConstants.CONTRIBUTION_ALREADY_EXISTS);
        }
        if (request.getContributionDate().isBefore(associationSettings.getCycleStartDate())) {
            throw new UnsupportedOperationException(I18nConstantsInjectedMessages.CONTRIBUTION_DATE_NOT_VALID_KEY, I18nConstants.CONTRIBUTION_DATE_NOT_VALID, I18nConstants.CONTRIBUTION_DATE_NOT_VALID);
        }
        contribution.setMember(member);
        associationAccount.setCurrentAmount(associationAccount.getCurrentAmount() + request.getAmount());
        associationAccount.setTotalAmount(associationAccount.getCurrentAmount() + associationAccount.getLoanBalance());
        associationAccountRepository.save(associationAccount);
        Contribution savedContribution = contributionRepository.save(contribution);
        return contributionConverter.convertToResponse(savedContribution);
    }

    @Override
    public List<ContributionResponse> getAllContributions() {
        return contributionRepository.findAll().stream().map(contributionConverter::convertToResponse).toList();
    }

    @Override
    public ContributionResponse getContributionById(Long id) {
        return null;
    }

    @Override
    public ContributionResponse updateContribution(Long id, ContributionRequest request) {
        Member member = memberRepository.findById(request.getMemberId()).orElseThrow(() -> new UnsupportedOperationException(I18nConstantsInjectedMessages.MEMBER_NOT_FOUND_KEY, I18nConstants.MEMBER_NOT_FOUND, I18nConstants.MEMBER_NOT_FOUND));
        AssociationSettings associationSettings = associationSettingsRepository.findById(1L).orElseThrow(() -> new UnsupportedOperationException(I18nConstantsInjectedMessages.ASSOCIATION_SETTINGS_NOT_FOUND_KEY, I18nConstants.ASSOCIATION_SETTINGS_NOT_FOUND, I18nConstants.ASSOCIATION_SETTINGS_NOT_FOUND));


        return contributionRepository.findById(id).map(contribution -> {
            if (request.getContributionDate() != null) {
                contribution.setContributionDate(request.getContributionDate());
            }
            if (request.getAmount() != null) {
                contribution.setAmount(request.getAmount());
            }
            if (request.getDescription() != null) {
                contribution.setDescription(request.getDescription());
            }
            if (request.getMemberId() != null) {
                contribution.setMember(member);
            }
            if (request.getAmount() < (member.getManyOfActions() * associationSettings.getContributionAmount()) || request.getAmount() > (member.getManyOfActions() * associationSettings.getContributionAmount())) {
                throw new UnsupportedOperationException(I18nConstantsInjectedMessages.CONTRIBUTION_AMOUNT_NOT_VALID_KEY, I18nConstants.CONTRIBUTION_AMOUNT_NOT_VALID, I18nConstants.CONTRIBUTION_AMOUNT_NOT_VALID);
            }
            Contribution savedContribution = contributionRepository.save(contribution);
            return contributionConverter.convertToResponse(savedContribution);
        }).orElseThrow(() -> new UnsupportedOperationException(I18nConstantsInjectedMessages.CONTRIBUTION_NOT_FOUND_KEY, I18nConstants.CONTRIBUTION_NOT_FOUND, I18nConstants.CONTRIBUTION_NOT_FOUND));
    }

    @Override
    public DeleteOperationResponse deleteContribution(Long id) {
        Contribution contribution = contributionRepository.findById(id).orElseThrow(() -> new UnsupportedOperationException(I18nConstantsInjectedMessages.CONTRIBUTION_NOT_FOUND_KEY, I18nConstants.CONTRIBUTION_NOT_FOUND, I18nConstants.CONTRIBUTION_NOT_FOUND));
        contributionRepository.deleteById(contribution.getId());
        return new DeleteOperationResponse(true);
    }

    @Override
    public List<ContributionResponse> getContributionsByMemberId(Long memberId) {
        return contributionRepository.getContributionsByMemberId(memberId).stream().map(contributionConverter::convertToResponse).toList();
    }
}
