package com.codeLearner.Ziganya.models.refund;

import com.codeLearner.Ziganya.models.credit.Credit;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Refund")
public class Refund {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate refundDate;
    private Double amount;

    @ManyToOne
    @JsonManagedReference
    private Credit credit;

    public Refund() {
    }

    public Refund(Long id, LocalDate refundDate, Double amount, Credit credit) {
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

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }
}
