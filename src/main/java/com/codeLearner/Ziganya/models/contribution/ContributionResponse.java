package com.codeLearner.Ziganya.models.contribution;

import com.codeLearner.Ziganya.models.member.MemberResponse;

import java.time.LocalDate;

public class ContributionResponse {
    private Long id;
    private LocalDate contributionDate;
    private Double amount;
    private String description;
    private MemberResponse member;


    public ContributionResponse() {
    }

    public ContributionResponse(Long id, LocalDate contributionDate, Double amount, String description) {
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

    public MemberResponse getMember() {
        return member;
    }

    public void setMember(MemberResponse member) {
        this.member = member;
    }
}
