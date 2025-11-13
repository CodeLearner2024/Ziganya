package com.codeLearner.Ziganya.models.settings;

import org.springframework.stereotype.Component;

@Component
public class AssociationSettingsConverter {

    public AssociationSettingsResponse convertToResponse(AssociationSettings associationSettings){
        AssociationSettingsResponse response = new AssociationSettingsResponse();
        response.setId(associationSettings.getId());
        response.setMaxOfActions(associationSettings.getMaxOfActions());
        response.setContributionAmount(associationSettings.getContributionAmount());
        response.setCycleStartDate(associationSettings.getCycleStartDate());
        response.setCycleEndDate(associationSettings.getCycleEndDate());
        response.setManyOfMemberShipFee(associationSettings.getManyOfMemberShipFee());
        response.setLatePaymentPenalityInPercentage(associationSettings.getLatePaymentPenalityInPercentage());
        response.setInterestFrequency(associationSettings.getInterestFrequency());
        response.setTimesOfContributionForCredit(associationSettings.getTimesOfContributionForCredit());
        response.setCreditRate(associationSettings.getCreditRate());
        response.setActivationAccountAmount(associationSettings.getActivationAccountAmount());
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
        associationSettings.setMaxOfActions(request.getMaxOfActions());
        associationSettings.setCreditRate(request.getCreditRate());
        associationSettings.setInterestFrequency(request.getInterestFrequency());
        associationSettings.setActivationAccountAmount(request.getActivationAccountAmount());
        return associationSettings;
    }
}
