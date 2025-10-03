package com.codeLearner.Ziganya.models.associationaccount;

public class AssociationAccountRequest {
    private Double currentAmount;
    private Double loanBalance;
    private Double totalAmount;

    public AssociationAccountRequest() {

    }

    public AssociationAccountRequest(Double currentAmount, Double loanBalance, Double totalAmount) {
        this.currentAmount = currentAmount;
        this.loanBalance = loanBalance;
        this.totalAmount = totalAmount;
    }

    public Double getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(Double currentAmount) {
        this.currentAmount = currentAmount;
    }

    public Double getLoanBalance() {
        return loanBalance;
    }

    public void setLoanBalance(Double loanBalance) {
        this.loanBalance = loanBalance;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
