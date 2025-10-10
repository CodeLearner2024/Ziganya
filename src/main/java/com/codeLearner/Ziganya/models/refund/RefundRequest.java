package com.codeLearner.Ziganya.models.refund;

import java.time.LocalDate;

public class RefundRequest {
    private LocalDate refundDate;
    private Double amount;
    private Long creditId;


    public RefundRequest() {
    }

    public RefundRequest(LocalDate refundDate, Double amount, Long creditId) {
        this.refundDate = refundDate;
        this.amount = amount;
        this.creditId = creditId;
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

    public Long getCreditId() {
        return creditId;
    }

    public void setCreditId(Long creditId) {
        this.creditId = creditId;
    }
}
