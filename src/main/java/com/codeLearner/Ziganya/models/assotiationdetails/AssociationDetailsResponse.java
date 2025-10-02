package com.codeLearner.Ziganya.models.assotiationdetails;

import java.time.LocalDate;

public class AssociationDetailsResponse {
    private Long id;
    private String name;
    private String email;
    private String contact;
    private LocalDate cycleStartDate;
    private LocalDate cycleEndDate;
    private String address;

    public AssociationDetailsResponse() {}

    public AssociationDetailsResponse(Long id, String name, String email, String contact, LocalDate cycleStartDate, LocalDate cycleEndDate, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.cycleStartDate = cycleStartDate;
        this.cycleEndDate = cycleEndDate;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
