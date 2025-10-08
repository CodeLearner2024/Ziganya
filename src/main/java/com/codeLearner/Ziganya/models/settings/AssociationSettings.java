package com.codeLearner.Ziganya.models.settings;

import com.codeLearner.Ziganya.models.enums.InterestFrequency;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "settings")
public class AssociationSettings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double contributionAmount;
    private Integer manyOfMemberShipFee;
    private Double latePaymentPenalityInPercentage;
    private LocalDate cycleStartDate;
    private LocalDate cycleEndDate;
    private Integer timesOfContributionForCredit;
    private Integer maxOfActions;
    private Double creditRate;
    private InterestFrequency interestFrequency;


    public AssociationSettings() {
    }

    public AssociationSettings(Long id, Double contributionAmount, Integer manyOfMemberShipFee, Double latePaymentPenalityInPercentage, LocalDate cycleStartDate, LocalDate cycleEndDate, Integer timesOfContributionForCredit, Integer maxOfActions) {
        this.id = id;
        this.contributionAmount = contributionAmount;
        this.manyOfMemberShipFee = manyOfMemberShipFee;
        this.latePaymentPenalityInPercentage = latePaymentPenalityInPercentage;
        this.cycleStartDate = cycleStartDate;
        this.cycleEndDate = cycleEndDate;
        this.timesOfContributionForCredit = timesOfContributionForCredit;
        this.maxOfActions = maxOfActions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getMaxOfActions() {
        return maxOfActions;
    }

    public void setMaxOfActions(Integer maxOfActions) {
        this.maxOfActions = maxOfActions;
    }

    public Double getCreditRate() {
        return creditRate;
    }

    public void setCreditRate(Double creditRate) {
        this.creditRate = creditRate;
    }

    public InterestFrequency getInterestFrequency() {
        return interestFrequency;
    }

    public void setInterestFrequency(InterestFrequency interestFrequency) {
        this.interestFrequency = interestFrequency;
    }
}
