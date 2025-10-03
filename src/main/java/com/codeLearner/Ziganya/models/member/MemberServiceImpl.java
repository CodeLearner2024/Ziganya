package com.codeLearner.Ziganya.models.member;

import com.codeLearner.Ziganya.exceptionhandling.exception.UnsupportedOperationException;
import com.codeLearner.Ziganya.i18n.I18nConstants;
import com.codeLearner.Ziganya.i18n.I18nConstantsInjectedMessages;
import com.codeLearner.Ziganya.util.DeleteOperationResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    private final MemberConverter memberConverter;
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberConverter memberConverter, MemberRepository memberRepository) {
        this.memberConverter = memberConverter;
        this.memberRepository = memberRepository;
    }

    @Override
    public MemberResponse createMember(MemberRequest request) {
        Member member = memberConverter.convertToEntity(request);
        Member savedMember = memberRepository.save(member);
        return memberConverter.convertToResponse(savedMember);
    }

    @Override
    public List<MemberResponse> getAllMembers() {
        return memberRepository.findAll().stream().map(memberConverter::convertToResponse).toList();
    }

    @Override
    public MemberResponse getMemberById(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(() -> new UnsupportedOperationException(I18nConstantsInjectedMessages.MEMBER_NOT_FOUND_KEY, I18nConstants.MEMBER_NOT_FOUND, I18nConstants.MEMBER_NOT_FOUND));
        return memberConverter.convertToResponse(member);
    }

    @Override
    public MemberResponse updateMember(Long id, MemberRequest request) {
        return memberRepository.findById(id).map(member -> {
            if (request.getFirstname() != null) {
                member.setFirstname(request.getFirstname());
            }
            if (request.getLastname() != null) {
                member.setLastname(request.getLastname());
            }
            if (request.getPhoneNumber() != null) {
                member.setPhoneNumber(request.getPhoneNumber());
            }
            if (request.getManyOfActions() != null) {
                member.setManyOfActions(request.getManyOfActions());
            }
            Member savedMember = memberRepository.save(member);
            return memberConverter.convertToResponse(savedMember);
        }).orElseThrow(() -> new UnsupportedOperationException(I18nConstantsInjectedMessages.MEMBER_NOT_FOUND_KEY, I18nConstants.MEMBER_NOT_FOUND, I18nConstants.MEMBER_NOT_FOUND));
    }

    @Override
    public DeleteOperationResponse deleteMember(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(() -> new UnsupportedOperationException(I18nConstantsInjectedMessages.MEMBER_NOT_FOUND_KEY, I18nConstants.MEMBER_NOT_FOUND, I18nConstants.MEMBER_NOT_FOUND));
        this.memberRepository.deleteById(member.getId());
        return new DeleteOperationResponse(true);
    }
}
