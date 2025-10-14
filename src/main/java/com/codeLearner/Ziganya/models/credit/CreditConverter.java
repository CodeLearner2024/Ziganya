package com.codeLearner.Ziganya.models.credit;

import com.codeLearner.Ziganya.models.enums.Decision;
import com.codeLearner.Ziganya.models.member.MemberConverter;
import org.springframework.stereotype.Component;

@Component
public class CreditConverter {
    private final MemberConverter memberConverter;

    public CreditConverter(MemberConverter memberConverter) {
        this.memberConverter = memberConverter;
    }

    public CreditResponse convertToResponse(Credit credit){
        CreditResponse response = new CreditResponse();
        response.setId(credit.getId());
        response.setAmount(credit.getAmount());
        response.setCreditDate(credit.getCreditDate());
        response.setInterestRate(credit.getInterestRate());
        response.setMember(memberConverter.convertToResponse(credit.getMember()));
        response.setCreditDecision(credit.getCreditDecision());

        return  response;
    }

    public Credit convertToEntity(CreditRequest request){
        Credit credit = new Credit();
        credit.setAmount(request.getAmount());
        credit.setCreditDate(request.getCreditDate());
        credit.setInterestRate(request.getInterestRate());
        credit.setCreditDecision(Decision.IN_TREATMENT);
        return credit;
    }
}
