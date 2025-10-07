package com.codeLearner.Ziganya.models.contribution;

import java.time.LocalDate;

public class ContributionRequest {
    private LocalDate contributionDate;
    private Double amount;
    private String description;
    private Long memberId;

    public ContributionRequest() {
    }

    public ContributionRequest(LocalDate contributionDate, Double amount, String description) {
        this.contributionDate = contributionDate;
        this.amount = amount;
        this.description = description;
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

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }
}
