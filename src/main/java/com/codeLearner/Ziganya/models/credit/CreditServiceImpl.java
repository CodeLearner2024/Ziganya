package com.codeLearner.Ziganya.models.credit;

import com.codeLearner.Ziganya.exceptionhandling.exception.UnsupportedOperationException;
import com.codeLearner.Ziganya.i18n.I18nConstants;
import com.codeLearner.Ziganya.i18n.I18nConstantsInjectedMessages;
import com.codeLearner.Ziganya.models.member.Member;
import com.codeLearner.Ziganya.models.member.MemberRepository;
import com.codeLearner.Ziganya.util.DeleteOperationResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditServiceImpl implements CreditService{

    private final CreditRepository creditRepository;
    private final CreditConverter creditConverter;
    private final MemberRepository memberRepository;

    public CreditServiceImpl(CreditRepository creditRepository, CreditConverter creditConverter, MemberRepository memberRepository) {
        this.creditRepository = creditRepository;
        this.creditConverter = creditConverter;
        this.memberRepository = memberRepository;
    }

    @Override
    public CreditResponse createCredit(CreditRequest request) {
        Member member = memberRepository.findById(request.getMemberId()).orElseThrow(() -> new UnsupportedOperationException(I18nConstantsInjectedMessages.MEMBER_NOT_FOUND_KEY, I18nConstants.MEMBER_NOT_FOUND, I18nConstants.MEMBER_NOT_FOUND));
        Credit credit = creditConverter.convertToEntity(request);
        credit.setMember(member);
        Credit savedCredit = creditRepository.save(credit);
        return creditConverter.convertToResponse(savedCredit);
    }

    @Override
    public List<CreditResponse> getAllCredits() {
        return creditRepository.findAll().stream().map(creditConverter::convertToResponse).toList();
    }

    @Override
    public CreditResponse updateCredit(Long id, CreditRequest request) {
        Member member = memberRepository.findById(request.getMemberId()).orElseThrow(() -> new UnsupportedOperationException(I18nConstantsInjectedMessages.MEMBER_NOT_FOUND_KEY, I18nConstants.MEMBER_NOT_FOUND, I18nConstants.MEMBER_NOT_FOUND));


        return creditRepository.findById(id).map(credit -> {
            if(request.getAmount() != null){
                credit.setAmount(request.getAmount());
            }
            if(request.getCreditDate() != null){
                credit.setCreditDate(request.getCreditDate());
            }
            if(request.getInterestRate() != null){
                credit.setInterestRate(request.getInterestRate());
            }
            if (request.getMemberId() != null){
                credit.setMember(member);
            }
            Credit savedCredit = creditRepository.save(credit);
            return creditConverter.convertToResponse(savedCredit);
        }).orElseThrow(() -> new UnsupportedOperationException(I18nConstantsInjectedMessages.CREDIT_NOT_FOUND_KEY, I18nConstants.CREDIT_NOT_FOUND, I18nConstants.CREDIT_NOT_FOUND));
    }

    @Override
    public List<CreditResponse> getCreditByMemberId(Long memberId) {
        return creditRepository.findByMemberId(memberId).stream().map(creditConverter::convertToResponse).toList();
    }

    @Override
    public DeleteOperationResponse deleteById(Long id) {
        Credit credit = creditRepository.findById(id).orElseThrow(() -> new UnsupportedOperationException(I18nConstantsInjectedMessages.CREDIT_NOT_FOUND_KEY, I18nConstants.CREDIT_NOT_FOUND, I18nConstants.CREDIT_NOT_FOUND));
        creditRepository.deleteById(credit.getId());
        return new DeleteOperationResponse(true);
    }
}
