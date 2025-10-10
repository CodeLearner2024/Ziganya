package com.codeLearner.Ziganya.models.member;

import com.codeLearner.Ziganya.exceptionhandling.exception.UnsupportedOperationException;
import com.codeLearner.Ziganya.i18n.I18nConstants;
import com.codeLearner.Ziganya.i18n.I18nConstantsInjectedMessages;
import com.codeLearner.Ziganya.models.settings.AssociationSettings;
import com.codeLearner.Ziganya.models.settings.AssociationSettingsRepository;
import com.codeLearner.Ziganya.util.DeleteOperationResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {
    private final MemberConverter memberConverter;
    private final MemberRepository memberRepository;
    private final AssociationSettingsRepository associationSettingsRepository;

    public MemberServiceImpl(MemberConverter memberConverter, MemberRepository memberRepository, AssociationSettingsRepository associationSettingsRepository) {
        this.memberConverter = memberConverter;
        this.memberRepository = memberRepository;
        this.associationSettingsRepository = associationSettingsRepository;
    }

    @Override
    public MemberResponse createMember(MemberRequest request) {
        Member member = memberConverter.convertToEntity(request);
        AssociationSettings associationSettings = associationSettingsRepository.findById(1L).orElseThrow(() -> new UnsupportedOperationException(I18nConstantsInjectedMessages.ASSOCIATION_SETTINGS_NOT_FOUND_KEY, I18nConstants.ASSOCIATION_SETTINGS_NOT_FOUND, I18nConstants.ASSOCIATION_SETTINGS_NOT_FOUND));
        if(memberRepository.existsByPhoneNumber(request.getPhoneNumber())){
            throw new UnsupportedOperationException(I18nConstantsInjectedMessages.MEMBER_PHONE_NUMBER_ALREADY_EXISTS_KEY,I18nConstants.MEMBER_PHONE_NUMBER_ALREADY_EXISTS,I18nConstants.MEMBER_PHONE_NUMBER_ALREADY_EXISTS);
        }
        if(request.getFirstname().trim().isBlank()){
            throw new UnsupportedOperationException(I18nConstantsInjectedMessages.MEMBER_FIRSTNAME_BLANK_KEY,I18nConstants.MEMBER_FIRSTNAME_BLANK,I18nConstants.MEMBER_FIRSTNAME_BLANK);
        }
        if(request.getLastname().trim().isBlank()){
            throw new UnsupportedOperationException(I18nConstantsInjectedMessages.MEMBER_LASTNAME_BLANK_KEY,I18nConstants.MEMBER_LASTNAME_BLANK,I18nConstants.MEMBER_LASTNAME_BLANK);
        }
        if(request.getPhoneNumber().trim().isBlank()){
            throw new UnsupportedOperationException(I18nConstantsInjectedMessages.MEMBER_PHONE_NUMBER_BLANK_KEY,I18nConstants.MEMBER_PHONE_NUMBER_ALREADY_EXISTS,I18nConstants.MEMBER_PHONE_NUMBER_BLANK);
        }
        if(request.getManyOfActions() < 1){
            throw new UnsupportedOperationException(I18nConstantsInjectedMessages.MEMBER_MANY_OF_ACTIONS_LESS_THAN_ONE_KEY,I18nConstants.MEMBER_MANY_OF_ACTIONS_LESS_THAN_ONE,I18nConstants.MEMBER_MANY_OF_ACTIONS_LESS_THAN_ONE);
        }
        if(request.getManyOfActions() > associationSettings.getMaxOfActions()){
            throw new UnsupportedOperationException(I18nConstantsInjectedMessages.MEMBER_MANY_OF_ACTIONS_GREATER_THAN_MAX_OF_ACTIONS_KEY,I18nConstants.MEMBER_MANY_OF_ACTIONS_GREATER_THAN_MAX_OF_ACTIONS,I18nConstants.MEMBER_MANY_OF_ACTIONS_GREATER_THAN_MAX_OF_ACTIONS);
        }
        String phoneNumber = request.getPhoneNumber().trim();
        if (!phoneNumber.matches("^\\+257\\d{8}$")) {
            throw new UnsupportedOperationException(
                    I18nConstantsInjectedMessages.MEMBER_PHONE_NUMBER_INVALID_KEY,
                    I18nConstants.MEMBER_PHONE_NUMBER_INVALID,I18nConstants.MEMBER_PHONE_NUMBER_INVALID);
        }
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
            Optional<Member> optionalMember = memberRepository.findByPhoneNumber(request.getPhoneNumber());
            if(optionalMember.isPresent() && !optionalMember.get().getId().equals(id)){
                throw new UnsupportedOperationException(I18nConstantsInjectedMessages.MEMBER_PHONE_NUMBER_ALREADY_EXISTS_KEY, I18nConstants.MEMBER_PHONE_NUMBER_ALREADY_EXISTS, I18nConstants.MEMBER_PHONE_NUMBER_ALREADY_EXISTS);
            }
            String phoneNumber = request.getPhoneNumber().trim();
            if (!phoneNumber.matches("^\\+257\\d{8}$")) {
                throw new UnsupportedOperationException(
                        I18nConstantsInjectedMessages.MEMBER_PHONE_NUMBER_INVALID_KEY,
                        I18nConstants.MEMBER_PHONE_NUMBER_INVALID,I18nConstants.MEMBER_PHONE_NUMBER_INVALID);
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
