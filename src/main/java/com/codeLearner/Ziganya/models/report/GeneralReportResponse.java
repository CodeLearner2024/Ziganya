package com.codeLearner.Ziganya.models.report;

public class GeneralReportResponse {
    private Integer manyofMembers;
    private Integer actions;
    private Double contributedAmount;
    private Double creditedAmount;
    private Double interestAmount;
    private Double contributionLatePenalityAmount;

    public GeneralReportResponse() {
    }

    public GeneralReportResponse(Integer actions, java.lang.Double contributedAmount, java.lang.Double creditedAmount, java.lang.Double interestAmount, java.lang.Double contributionLatePenalityAmount) {
        this.actions = actions;
        this.contributedAmount = contributedAmount;
        this.creditedAmount = creditedAmount;
        this.interestAmount = interestAmount;
        this.contributionLatePenalityAmount = contributionLatePenalityAmount;
    }

    public Integer getActions() {
        return actions;
    }

    public void setActions(Integer actions) {
        this.actions = actions;
    }

    public java.lang.Double getContributedAmount() {
        return contributedAmount;
    }

    public void setContributedAmount(java.lang.Double contributedAmount) {
        this.contributedAmount = contributedAmount;
    }

    public java.lang.Double getCreditedAmount() {
        return creditedAmount;
    }

    public void setCreditedAmount(java.lang.Double creditedAmount) {
        this.creditedAmount = creditedAmount;
    }

    public java.lang.Double getInterestAmount() {
        return interestAmount;
    }

    public void setInterestAmount(java.lang.Double interestAmount) {
        this.interestAmount = interestAmount;
    }

    public java.lang.Double getContributionLatePenalityAmount() {
        return contributionLatePenalityAmount;
    }

    public void setContributionLatePenalityAmount(java.lang.Double contributionLatePenalityAmount) {
        this.contributionLatePenalityAmount = contributionLatePenalityAmount;
    }

    public Integer getManyofMembers() {
        return manyofMembers;
    }

    public void setManyofMembers(Integer manyofMembers) {
        this.manyofMembers = manyofMembers;
    }
}
