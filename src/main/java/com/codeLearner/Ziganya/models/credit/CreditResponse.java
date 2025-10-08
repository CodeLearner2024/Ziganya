package com.codeLearner.Ziganya.models.credit;

import java.time.LocalDate;

public class CreditResponse {
    private Long id;
    private Double amount;
    private LocalDate creditDate;
    private Double interestRate;

    public CreditResponse() {
    }

    public CreditResponse(Long id, Double amount, LocalDate creditDate, Double interestRate) {
        this.id = id;
        this.amount = amount;
        this.creditDate = creditDate;
        this.interestRate = interestRate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
