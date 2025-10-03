package com.codeLearner.Ziganya.models.member;


public class MemberRequest {
    private String firstname;
    private String lastname;
    private String  phoneNumber;
    private Integer manyOfActions;

    public MemberRequest() {

    }

    public MemberRequest(String firstname, String lastname, String phoneNumber, Integer manyOfActions) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
        this.manyOfActions = manyOfActions;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getManyOfActions() {
        return manyOfActions;
    }

    public void setManyOfActions(Integer manyOfActions) {
        this.manyOfActions = manyOfActions;
    }
}
