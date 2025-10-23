package com.codeLearner.Ziganya.models.contribution;

import com.codeLearner.Ziganya.models.member.Member;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Month;

@Entity
@Table(name = "contributions")
public class Contribution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate contributionDate;
    private Double amount;
    private String description;
    @Enumerated(EnumType.STRING)
    private Month month;
    private Double latePenaltyAmount;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Member member;


    public Contribution() {
    }

    public Contribution(Long id, LocalDate contributionDate, Double amount, String description) {
        this.id = id;
        this.contributionDate = contributionDate;
        this.amount = amount;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getContributionDate() {
        return contributionDate;
    }

    public void setContributionDate(LocalDate contributionDate) {
        this.contributionDate = contributionDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public Double getLatePenaltyAmount() {
        return latePenaltyAmount;
    }

    public void setLatePenaltyAmount(Double latePenaltyAmount) {
        this.latePenaltyAmount = latePenaltyAmount;
    }
}
