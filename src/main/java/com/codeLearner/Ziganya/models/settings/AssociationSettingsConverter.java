package com.codeLearner.Ziganya.models.settings;

import org.springframework.stereotype.Component;

@Component
public class AssociationSettingsConverter {

    public AssociationSettingsResponse convertToResponse(AssociationSettings associationSettings){
        AssociationSettingsResponse response = new AssociationSettingsResponse();
        response.setId(associationSettings.getId());
        response.setContributionAmount(associationSettings.getContributionAmount());
        response.setCycleStartDate(associationSettings.getCycleStartDate());
        response.setCycleEndDate(associationSettings.getCycleEndDate());
        response.setManyOfMemberShipFee(associationSettings.getManyOfMemberShipFee());
        response.setLatePaymentPenalityInPercentage(associationSettings.getLatePaymentPenalityInPercentage());
        return response;
    }

    public AssociationSettings convertToEntity(AssociationSettingsRequest request){

        AssociationSettings associationSettings = new AssociationSettings();
        associationSettings.setContributionAmount(request.getContributionAmount());
        associationSettings.setCycleEndDate(request.getCycleEndDate());
        associationSettings.setCycleStartDate(request.getCycleStartDate());
        associationSettings.setManyOfMemberShipFee(request.getManyOfMemberShipFee());
        associationSettings.setLatePaymentPenalityInPercentage(request.getLatePaymentPenalityInPercentage());
        associationSettings.setTimesOfContributionForCredit(request.getTimesOfContributionForCredit());
        return associationSettings;
    }
}
