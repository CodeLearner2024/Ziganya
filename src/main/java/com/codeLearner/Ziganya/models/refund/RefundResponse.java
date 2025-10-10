package com.codeLearner.Ziganya.models.refund;

import com.codeLearner.Ziganya.models.credit.CreditResponse;

import java.time.LocalDate;

public class RefundResponse {
    private Long id;
    private LocalDate refundDate;
    private Double amount;
    private CreditResponse credit;

    public RefundResponse() {
    }

    public RefundResponse(Long id, LocalDate refundDate, Double amount, CreditResponse credit) {
        this.id = id;
        this.refundDate = refundDate;
        this.amount = amount;
        this.credit = credit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getRefundDate() {
        return refundDate;
    }

    public void setRefundDate(LocalDate refundDate) {
        this.refundDate = refundDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public CreditResponse getCredit() {
        return credit;
    }

    public void setCredit(CreditResponse credit) {
        this.credit = credit;
    }
}
