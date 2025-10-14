package com.codeLearner.Ziganya.models.credittreatment;

import com.codeLearner.Ziganya.models.credit.Credit;
import com.codeLearner.Ziganya.models.enums.Decision;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "credit_traitments")
public class CreditTraitment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate traitmentDate;
    private Decision decision;

    @OneToOne
    @JoinColumn(name = "credit_id")
    private Credit credit;

    public CreditTraitment() {
    }

    public CreditTraitment(Long id, LocalDate traitmentDate, Decision decision, Credit credit) {
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

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }
}
