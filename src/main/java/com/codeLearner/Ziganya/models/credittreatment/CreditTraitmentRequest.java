package com.codeLearner.Ziganya.models.credittreatment;

import com.codeLearner.Ziganya.models.enums.Decision;

import java.time.LocalDate;

public class CreditTraitmentRequest {
    private LocalDate traitmentDate;
    private Decision decision;
    private Long creditId;
    private Decision creditDecision;
    private Double totalToPay;



    public CreditTraitmentRequest() {
    }

    public CreditTraitmentRequest(LocalDate traitmentDate, Decision decision, Long creditId) {
        this.traitmentDate = traitmentDate;
        this.decision = decision;
        this.creditId = creditId;
    }

    public LocalDate getTraitmentDate() {
        return traitmentDate;
    }

    public void setTraitmentDate(LocalDate traitmentDate) {
        this.traitmentDate = traitmentDate;
    }

    public Decision getDecision() {
        return decision;
    }

    public void setDecision(Decision decision) {
        this.decision = decision;
    }

    public Long getCreditId() {
        return creditId;
    }

    public void setCreditId(Long creditId) {
        this.creditId = creditId;
    }

    public Decision getCreditDecision() {
        return creditDecision;
    }

    public void setCreditDecision(Decision creditDecision) {
        this.creditDecision = creditDecision;
    }

    public Double getTotalToPay() {
        return totalToPay;
    }

    public void setTotalToPay(Double totalToPay) {
        this.totalToPay = totalToPay;
    }
}
