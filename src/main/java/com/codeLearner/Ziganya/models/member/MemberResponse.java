package com.codeLearner.Ziganya.models.member;

public class MemberResponse {
    private Long id;
    private String firstname;
    private String lastname;
    private String  phoneNumber;
    private Integer manyOfActions;

    public MemberResponse() {

    }

    public MemberResponse(Long id, String firstname, String lastname, String phoneNumber, Integer manyOfActions) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
        this.manyOfActions = manyOfActions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
