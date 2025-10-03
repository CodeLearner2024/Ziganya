package com.codeLearner.Ziganya.models.member;

import org.springframework.stereotype.Component;

@Component
public class MemberConverter {

    public MemberResponse convertToResponse(Member member){
        MemberResponse response = new MemberResponse();
        response.setId(member.getId());
        response.setFirstname(member.getFirstname());
        response.setLastname(member.getLastname());
        response.setPhoneNumber(member.getPhoneNumber());
        response.setManyOfActions(member.getManyOfActions());
        return  response;
    }

    public Member convertToEntity(MemberRequest request){
        Member member = new Member();
        member.setFirstname(request.getFirstname());
        member.setLastname(request.getLastname());
        member.setPhoneNumber(request.getPhoneNumber());
        member.setManyOfActions(request.getManyOfActions());
        return member;
    }
}
