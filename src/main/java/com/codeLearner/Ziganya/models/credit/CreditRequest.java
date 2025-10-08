package com.codeLearner.Ziganya.models.credit;

import java.time.LocalDate;

public class CreditRequest {
    private Double amount;
    private LocalDate creditDate;
    private Double interestRate;
    private Long memberId;

    public CreditRequest() {
    }

    public CreditRequest(Double amount, LocalDate creditDate, Double interestRate) {
        this.amount = amount;
        this.creditDate = creditDate;
        this.interestRate = interestRate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getCreditDate() {
        return creditDate;
    }

    public void setCreditDate(LocalDate creditDate) {
        this.creditDate = creditDate;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }
}
