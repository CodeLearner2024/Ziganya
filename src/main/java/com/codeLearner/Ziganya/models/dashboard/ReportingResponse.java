package com.codeLearner.Ziganya.models.dashboard;

public class ReportingResponse {
    private Integer totalMembers;
    private Integer totalActions;
    private Double  totalCurrentBalance;
    private Double totalLoanBalance;
    private String assocoiationName;

    public ReportingResponse() {
    }

    public ReportingResponse(Integer totalMembers, Integer totalActions, Double totalCurrentBalance, Double totalLoanBalance) {
        this.totalMembers = totalMembers;
        this.totalActions = totalActions;
        this.totalCurrentBalance = totalCurrentBalance;
        this.totalLoanBalance = totalLoanBalance;
    }

    public Integer getTotalMembers() {
        return totalMembers;
    }

    public void setTotalMembers(Integer totalMembers) {
        this.totalMembers = totalMembers;
    }

    public Integer getTotalActions() {
        return totalActions;
    }

    public void setTotalActions(Integer totalActions) {
        this.totalActions = totalActions;
    }

    public Double getTotalCurrentBalance() {
        return totalCurrentBalance;
    }

    public void setTotalCurrentBalance(Double totalCurrentBalance) {
        this.totalCurrentBalance = totalCurrentBalance;
    }

    public Double getTotalLoanBalance() {
        return totalLoanBalance;
    }

    public void setTotalLoanBalance(Double totalLoanBalance) {
        this.totalLoanBalance = totalLoanBalance;
    }

    public String getAssocoiationName() {
        return assocoiationName;
    }

    public void setAssocoiationName(String assocoiationName) {
        this.assocoiationName = assocoiationName;
    }
}
