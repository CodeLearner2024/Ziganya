package com.codeLearner.Ziganya.models.credit;

import com.codeLearner.Ziganya.exceptionhandling.exception.UnsupportedOperationException;
import com.codeLearner.Ziganya.i18n.I18nConstants;
import com.codeLearner.Ziganya.i18n.I18nConstantsInjectedMessages;
import com.codeLearner.Ziganya.models.associationaccount.AssociationAccount;
import com.codeLearner.Ziganya.models.associationaccount.AssociationAccountRepository;
import com.codeLearner.Ziganya.models.enums.InterestFrequency;
import com.codeLearner.Ziganya.models.member.Member;
import com.codeLearner.Ziganya.models.member.MemberRepository;
import com.codeLearner.Ziganya.models.settings.AssociationSettings;
import com.codeLearner.Ziganya.models.settings.AssociationSettingsRepository;
import com.codeLearner.Ziganya.util.DeleteOperationResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class CreditServiceImpl implements CreditService {

    private final CreditRepository creditRepository;
    private final CreditConverter creditConverter;
    private final MemberRepository memberRepository;
    private final AssociationAccountRepository associationAccountRepository;
    private final AssociationSettingsRepository associationSettingsRepository;

    public CreditServiceImpl(CreditRepository creditRepository, CreditConverter creditConverter, MemberRepository memberRepository, AssociationAccountRepository associationAccountRepository, AssociationSettingsRepository associationSettingsRepository) {
        this.creditRepository = creditRepository;
        this.creditConverter = creditConverter;
        this.memberRepository = memberRepository;
        this.associationAccountRepository = associationAccountRepository;
        this.associationSettingsRepository = associationSettingsRepository;
    }

    @Override
    public CreditResponse createCredit(CreditRequest request) {
        AssociationSettings associationSettings = associationSettingsRepository.findById(1L).orElseThrow(() -> new UnsupportedOperationException(I18nConstantsInjectedMessages.ASSOCIATION_SETTINGS_NOT_FOUND_KEY, I18nConstants.ASSOCIATION_SETTINGS_NOT_FOUND, I18nConstants.ASSOCIATION_SETTINGS_NOT_FOUND));
        Member member = memberRepository.findById(request.getMemberId()).orElseThrow(() -> new UnsupportedOperationException(I18nConstantsInjectedMessages.MEMBER_NOT_FOUND_KEY, I18nConstants.MEMBER_NOT_FOUND, I18nConstants.MEMBER_NOT_FOUND));
        if (member == null) {
            throw new UnsupportedOperationException(I18nConstantsInjectedMessages.CREDIT_MEMBER_MUST_BE_PROVIDED_KEY, I18nConstants.CREDIT_MEMBER_MUST_BE_PROVIDED, I18nConstants.CREDIT_MEMBER_MUST_BE_PROVIDED);
        }
        Credit credit = creditConverter.convertToEntity(request);
        credit.setMember(member);
        credit.setInterestRate(associationSettings.getCreditRate());
        Credit savedCredit = creditRepository.save(credit);
        return creditConverter.convertToResponse(savedCredit);
    }

    @Override
    public List<CreditResponse> getAllCredits() {
        return creditRepository.findAll().stream().map(credit -> {
                    CreditResponse response = creditConverter.convertToResponse(credit);
                    AssociationSettings associationSettings = associationSettingsRepository.findById(1L).orElseThrow(() -> new UnsupportedOperationException(I18nConstantsInjectedMessages.ASSOCIATION_SETTINGS_NOT_FOUND_KEY, I18nConstants.ASSOCIATION_SETTINGS_NOT_FOUND, I18nConstants.ASSOCIATION_SETTINGS_NOT_FOUND));
                    if (associationSettings.getInterestFrequency() == InterestFrequency.DAILY) {
                        LocalDate currentDate = LocalDate.now();
                        LocalDate requestDate = credit.getCreditDate();
                        Long days = ChronoUnit.DAYS.between(currentDate, requestDate);
                        double interest = credit.getAmount() * associationSettings.getCreditRate() * days / 100;
                        response.setTotalAmountToPay(credit.getAmount() + interest);

                    } else {
                        double interest = credit.getAmount() * associationSettings.getCreditRate() / 100;
                        response.setTotalAmountToPay(credit.getAmount() + interest);
                    }
                    return response;
                }

        ).toList();
    }

    @Override
    public CreditResponse updateCredit(Long id, CreditRequest request) {
        Member member = memberRepository.findById(request.getMemberId()).orElseThrow(() -> new UnsupportedOperationException(I18nConstantsInjectedMessages.MEMBER_NOT_FOUND_KEY, I18nConstants.MEMBER_NOT_FOUND, I18nConstants.MEMBER_NOT_FOUND));


        return creditRepository.findById(id).map(credit -> {
            if (request.getAmount() != null) {
                credit.setAmount(request.getAmount());
            }
            if (request.getCreditDate() != null) {
                credit.setCreditDate(request.getCreditDate());
            }
            if (request.getInterestRate() != null) {
                credit.setInterestRate(request.getInterestRate());
            }
            if (request.getMemberId() != null) {
                credit.setMember(member);
            }
            Credit savedCredit = creditRepository.save(credit);
            return creditConverter.convertToResponse(savedCredit);
        }).orElseThrow(() -> new UnsupportedOperationException(I18nConstantsInjectedMessages.CREDIT_NOT_FOUND_KEY, I18nConstants.CREDIT_NOT_FOUND, I18nConstants.CREDIT_NOT_FOUND));
    }

    @Override
    public List<CreditResponse> getCreditByMemberId(Long memberId) {
        return creditRepository.findByMemberId(memberId).stream().map(creditConverter::convertToResponse).toList();
    }

    @Override
    public DeleteOperationResponse deleteById(Long id) {
        Credit credit = creditRepository.findById(id).orElseThrow(() -> new UnsupportedOperationException(I18nConstantsInjectedMessages.CREDIT_NOT_FOUND_KEY, I18nConstants.CREDIT_NOT_FOUND, I18nConstants.CREDIT_NOT_FOUND));
        creditRepository.deleteById(credit.getId());
        return new DeleteOperationResponse(true);
    }
}
