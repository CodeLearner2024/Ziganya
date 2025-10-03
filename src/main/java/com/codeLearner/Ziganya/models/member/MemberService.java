package com.codeLearner.Ziganya.models.member;

import com.codeLearner.Ziganya.util.DeleteOperationResponse;

import java.util.List;

public interface MemberService {

    public  MemberResponse createMember(MemberRequest request);
    public List<MemberResponse> getAllMembers();

    public MemberResponse getMemberById(Long id);

    public MemberResponse updateMember(Long id, MemberRequest request);

    public DeleteOperationResponse deleteMember(Long id);
}
