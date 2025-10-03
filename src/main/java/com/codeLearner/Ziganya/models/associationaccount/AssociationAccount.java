package com.codeLearner.Ziganya.models.associationaccount;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "association_accounts")
public class AssociationAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double currentAmount;
    private Double loanBalance;
    private Double totalAmount;
    private LocalDate cycleStartDate;
    private LocalDate cycleEndDate;

    public AssociationAccount() {
    }

    public AssociationAccount(Long id, Double currentAmount, Double loanBalance, Double totalAmount, LocalDate cycleStartDate, LocalDate cycleEndDate) {
        this.id = id;
        this.currentAmount = currentAmount;
        this.loanBalance = loanBalance;
        this.totalAmount = totalAmount;
        this.cycleStartDate = cycleStartDate;
        this.cycleEndDate = cycleEndDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(Double currentAmount) {
        this.currentAmount = currentAmount;
    }

    public Double getLoanBalance() {
        return loanBalance;
    }

    public void setLoanBalance(Double loanBalance) {
        this.loanBalance = loanBalance;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDate getCycleStartDate() {
        return cycleStartDate;
    }

    public void setCycleStartDate(LocalDate cycleStartDate) {
        this.cycleStartDate = cycleStartDate;
    }

    public LocalDate getCycleEndDate() {
        return cycleEndDate;
    }

    public void setCycleEndDate(LocalDate cycleEndDate) {
        this.cycleEndDate = cycleEndDate;
    }
}
