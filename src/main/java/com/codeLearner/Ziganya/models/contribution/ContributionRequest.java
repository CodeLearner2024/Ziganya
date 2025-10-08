package com.codeLearner.Ziganya.models.contribution;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class ContributionRequest {
    private LocalDate contributionDate;
    @NotNull(message = "Amount of contribution must be provided")
    private Double amount;
    private String description;
    @NotNull(message = "Member must be provided")
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
