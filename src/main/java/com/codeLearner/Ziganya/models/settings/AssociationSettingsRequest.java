package com.codeLearner.Ziganya.models.settings;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class AssociationSettingsRequest {
    @NotNull(message = "contribution amount must be provided")
    private Double contributionAmount;
    @NotNull(message = "how much fee for membership")
    private Integer manyOfMemberShipFee;
    private Double latePaymentPenalityInPercentage;
    private LocalDate cycleStartDate;
    private LocalDate cycleEndDate;
    private Integer timesOfContributionForCredit;
    private Integer manyOfActions;

    public AssociationSettingsRequest() {

    }

    public AssociationSettingsRequest(Double contributionAmount, Integer manyOfMemberShipFee, Double latePaymentPenalityInPercentage, LocalDate cycleStartDate, LocalDate cycleEndDate, Integer timesOfContributionForCredit) {
        this.contributionAmount = contributionAmount;
        this.manyOfMemberShipFee = manyOfMemberShipFee;
        this.latePaymentPenalityInPercentage = latePaymentPenalityInPercentage;
        this.cycleStartDate = cycleStartDate;
        this.cycleEndDate = cycleEndDate;
        this.timesOfContributionForCredit = timesOfContributionForCredit;
    }

    public Double getContributionAmount() {
        return contributionAmount;
    }

    public void setContributionAmount(Double contributionAmount) {
        this.contributionAmount = contributionAmount;
    }

    public Integer getManyOfMemberShipFee() {
        return manyOfMemberShipFee;
    }

    public void setManyOfMemberShipFee(Integer manyOfMemberShipFee) {
        this.manyOfMemberShipFee = manyOfMemberShipFee;
    }

    public Double getLatePaymentPenalityInPercentage() {
        return latePaymentPenalityInPercentage;
    }

    public void setLatePaymentPenalityInPercentage(Double latePaymentPenalityInPercentage) {
        this.latePaymentPenalityInPercentage = latePaymentPenalityInPercentage;
    }

    public LocalDate getCycleStartDate() {
        return cycleStartDate;
    }

    public void setCycleStartDate(LocalDate cycleStartDate) {
        this.cycleStartDate = cycleStartDate;
    }

    public LocalDate getCycleEndDate() {
        return cycleEndDate;
    }

    public void setCycleEndDate(LocalDate cycleEndDate) {
        this.cycleEndDate = cycleEndDate;
    }

    public Integer getTimesOfContributionForCredit() {
        return timesOfContributionForCredit;
    }

    public void setTimesOfContributionForCredit(Integer timesOfContributionForCredit) {
        this.timesOfContributionForCredit = timesOfContributionForCredit;
    }

    public Integer getManyOfActions() {
        return manyOfActions;
    }

    public void setManyOfActions(Integer manyOfActions) {
        this.manyOfActions = manyOfActions;
    }
}
