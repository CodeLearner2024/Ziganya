package com.codeLearner.Ziganya.models.settings;

import com.codeLearner.Ziganya.exceptionhandling.exception.UnsupportedOperationException;
import com.codeLearner.Ziganya.i18n.I18nConstants;
import com.codeLearner.Ziganya.i18n.I18nConstantsInjectedMessages;
import com.codeLearner.Ziganya.util.DeleteOperationResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssociationSettingsServiceImpl implements AssociationSettingsService {

    private final AssociationSettingsRepository associationSettingsRepository;
    private final AssociationSettingsConverter associationSettingsConverter;

    public AssociationSettingsServiceImpl(AssociationSettingsRepository associationSettingsRepository, AssociationSettingsConverter associationSettingsConverter) {
        this.associationSettingsRepository = associationSettingsRepository;
        this.associationSettingsConverter = associationSettingsConverter;
    }


    @Override
    public AssociationSettingsResponse createAssociationSettings(AssociationSettingsRequest associationSettingsRequest) {
        AssociationSettings associationSettings = associationSettingsConverter.convertToEntity(associationSettingsRequest);
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
