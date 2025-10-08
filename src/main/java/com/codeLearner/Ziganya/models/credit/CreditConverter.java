package com.codeLearner.Ziganya.models.credit;

import org.springframework.stereotype.Component;

@Component
public class CreditConverter {


    public CreditResponse convertToResponse(Credit credit){
        CreditResponse response = new CreditResponse();
        response.setId(credit.getId());
        response.setAmount(credit.getAmount());
        response.setCreditDate(credit.getCreditDate());
        response.setInterestRate(credit.getInterestRate());
        return  response;
    }

    public Credit convertToEntity(CreditRequest request){
        Credit credit = new Credit();
        credit.setAmount(request.getAmount());
        credit.setCreditDate(request.getCreditDate());
        credit.setInterestRate(request.getInterestRate());
        return credit;
    }
}
