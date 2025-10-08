package com.codeLearner.Ziganya.models.credittraitment;

import com.codeLearner.Ziganya.models.credit.CreditResponse;
import com.codeLearner.Ziganya.models.enums.Decision;

import java.time.LocalDate;

public class CreditTraitmentResponse {
    private Long id;
    private LocalDate traitmentDate;
    private Decision decision;
    private CreditResponse credit;


    public CreditTraitmentResponse() {
    }

    public CreditTraitmentResponse(Long id, LocalDate traitmentDate, Decision decision, CreditResponse credit) {
        this.id = id;
        this.traitmentDate = traitmentDate;
        this.decision = decision;
        this.credit = credit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public CreditResponse getCredit() {
        return credit;
    }

    public void setCredit(CreditResponse credit) {
        this.credit = credit;
    }
}
