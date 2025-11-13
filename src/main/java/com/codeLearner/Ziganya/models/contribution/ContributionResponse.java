package com.codeLearner.Ziganya.models.contribution;

import com.codeLearner.Ziganya.models.enums.ContributionStatus;
import com.codeLearner.Ziganya.models.member.MemberResponse;

import java.time.LocalDate;
import java.time.Month;

public class ContributionResponse {
    private Long id;
    private LocalDate contributionDate;
    private Double amount;
    private String description;
    private MemberResponse member;
    private Month month;
    private Double latePenaltyAmount;
    private ContributionStatus status;



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
