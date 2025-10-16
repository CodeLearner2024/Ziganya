package com.codeLearner.Ziganya.models.credit;

import com.codeLearner.Ziganya.models.enums.Decision;
import com.codeLearner.Ziganya.models.member.Member;
import com.codeLearner.Ziganya.models.refund.Refund;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "credits")
public class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double amount;
    private LocalDate creditDate;
    private Double interestRate;
    private Decision creditDecision;
    private Double totalToPay;

    @ManyToOne
    @JsonManagedReference
    private Member member;

    @OneToMany(mappedBy = "credit")
    @JsonBackReference
    private List<Refund> refunds;


    public Credit() {
    }

    public Credit(Long id, Double amount, LocalDate creditDate, Double interestRate) {
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

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
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
