package com.codeLearner.Ziganya.models.report;

import com.codeLearner.Ziganya.models.member.MemberResponse;

public class ReportResponse {
    private MemberResponse memberResponse;
    private Integer actions;
    private Double contributedAmount;
    private Double loanAmount;
    private Double refundAmount;
    private Double interestAmount;
    private Double totalAmount;

    public ReportResponse() {
    }

    public MemberResponse getMemberResponse() {
        return memberResponse;
    }

    public void setMemberResponse(MemberResponse memberResponse) {
        this.memberResponse = memberResponse;
    }

    public Integer getActions() {
        return actions;
    }

    public void setActions(Integer actions) {
        this.actions = actions;
    }

    public Double getContributedAmount() {
        return contributedAmount;
    }

    public void setContributedAmount(Double contributedAmount) {
        this.contributedAmount = contributedAmount;
    }

    public Double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Double getInterestAmount() {
        return interestAmount;
    }

    public void setInterestAmount(Double interestAmount) {
        this.interestAmount = interestAmount;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(Double refundAmount) {
        this.refundAmount = refundAmount;
    }
}
