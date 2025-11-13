package com.codeLearner.Ziganya.models.associationaccount;

public class AssociationAccountResponse {
    private Long id;
    private Double currentAmount;
    private Double loanBalance;
    private Double totalAmount;
    private Double interestAmount;


    public AssociationAccountResponse() {
    }

    public AssociationAccountResponse(Long id, Double currentAmount, Double loanBalance, Double totalAmount) {
        this.id = id;
        this.currentAmount = currentAmount;
        this.loanBalance = loanBalance;
        this.totalAmount = totalAmount;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Double getInterestAmount() {
        return interestAmount;
    }

    public void setInterestAmount(Double interestAmount) {
        this.interestAmount = interestAmount;
    }
}
