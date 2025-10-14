package com.codeLearner.Ziganya.models.settings;

import com.codeLearner.Ziganya.exceptionhandling.exception.UnsupportedOperationException;
import com.codeLearner.Ziganya.i18n.I18nConstants;
import com.codeLearner.Ziganya.i18n.I18nConstantsInjectedMessages;
import com.codeLearner.Ziganya.models.associationaccount.AssociationAccount;
import com.codeLearner.Ziganya.models.associationaccount.AssociationAccountRepository;
import com.codeLearner.Ziganya.util.DeleteOperationResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssociationSettingsServiceImpl implements AssociationSettingsService {

    private final AssociationSettingsRepository associationSettingsRepository;
    private final AssociationSettingsConverter associationSettingsConverter;
    private final AssociationAccountRepository associationAccountRepository;

    public AssociationSettingsServiceImpl(AssociationSettingsRepository associationSettingsRepository, AssociationSettingsConverter associationSettingsConverter, AssociationAccountRepository associationAccountRepository) {
        this.associationSettingsRepository = associationSettingsRepository;
        this.associationSettingsConverter = associationSettingsConverter;
        this.associationAccountRepository = associationAccountRepository;
    }


    @Override
    public AssociationSettingsResponse createAssociationSettings(AssociationSettingsRequest associationSettingsRequest) {
        AssociationSettings currentAssociationSettings = associationSettingsRepository.fetchCurrentAssociationSettings();
        AssociationSettings associationSettings = associationSettingsConverter.convertToEntity(associationSettingsRequest);
        AssociationAccount associationAccount = new AssociationAccount();
        associationAccount.setId(1L);
        associationAccount.setCurrentAmount(0.0);
        associationAccount.setLoanBalance(0.0);
        associationAccount.setTotalAmount(0.0);
        associationAccount.setCycleStartDate(associationSettingsRequest.getCycleStartDate());
        associationAccount.setCycleEndDate(null);
        if (currentAssociationSettings != null) {
            currentAssociationSettings.setCycleEndDate(associationSettingsRequest.getCycleStartDate());
        }
        associationAccountRepository.save(associationAccount);
        AssociationSettings savedAssociationSettings = associationSettingsRepository.save(associationSettings);
        return associationSettingsConverter.convertToResponse(savedAssociationSettings);
    }

    @Override
    public List<AssociationSettingsResponse> findAllAssociationSettings() {
        return associationSettingsRepository.findAll().stream().map(associationSettingsConverter::convertToResponse).toList();
    }

    @Override
    public AssociationSettingsResponse updateAssociationSettings(Long id, AssociationSettingsRequest associationSettingsRequest) {

        return associationSettingsRepository.findById(id).map(associationSettings -> {
            associationSettings.setId(1L);
            if (associationSettingsRequest.getContributionAmount() != null) {
                associationSettings.setContributionAmount(associationSettingsRequest.getContributionAmount());
            }
            if (associationSettingsRequest.getCycleEndDate() != null) {
                associationSettings.setCycleEndDate(associationSettingsRequest.getCycleEndDate());
            }
            if (associationSettingsRequest.getCycleStartDate() != null) {
                associationSettings.setCycleStartDate(associationSettingsRequest.getCycleStartDate());
            }
            if (associationSettingsRequest.getLatePaymentPenalityInPercentage() != null) {
                associationSettings.setLatePaymentPenalityInPercentage(associationSettingsRequest.getLatePaymentPenalityInPercentage());
            }

            if (associationSettingsRequest.getManyOfMemberShipFee() != null) {
                associationSettings.setManyOfMemberShipFee(associationSettingsRequest.getManyOfMemberShipFee());
            }

            AssociationSettings savedAssociationSettings = associationSettingsRepository.save(associationSettings);
            return associationSettingsConverter.convertToResponse(savedAssociationSettings);

        }).orElseThrow(() -> new UnsupportedOperationException(I18nConstantsInjectedMessages.ASSOCIATION_SETTINGS_NOT_FOUND_KEY, I18nConstants.ASSOCIATION_SETTINGS_NOT_FOUND, I18nConstants.ASSOCIATION_SETTINGS_NOT_FOUND));
    }

    @Override
    public DeleteOperationResponse deleteAssociationSettings(Long id) {
        AssociationSettings associationSettings = associationSettingsRepository.findById(id).orElseThrow(() -> new UnsupportedOperationException(I18nConstantsInjectedMessages.ASSOCIATION_SETTINGS_NOT_FOUND_KEY, I18nConstants.ASSOCIATION_SETTINGS_NOT_FOUND, I18nConstants.ASSOCIATION_SETTINGS_NOT_FOUND));
        associationSettingsRepository.deleteById(associationSettings.getId());
        return new DeleteOperationResponse(true);
    }
}
