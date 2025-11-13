package com.codeLearner.Ziganya.models.contribution;

import com.codeLearner.Ziganya.models.enums.ContributionStatus;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.Month;

public class ContributionRequest {
    private LocalDate contributionDate;
    @NotNull(message = "Amount of contribution must be provided")
    private Double amount;
    private String description;
    @NotNull(message = "Member must be provided")
    private Long memberId;
    @NotNull(message = "Month must be provided")
    private Month month;
    private Double latePenaltyAmount;
    @NotNull(message = "Status must be provided")
    private ContributionStatus status;


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

    public ContributionStatus getStatus() {
        return status;
    }

    public void setStatus(ContributionStatus status) {
        this.status = status;
    }
}
