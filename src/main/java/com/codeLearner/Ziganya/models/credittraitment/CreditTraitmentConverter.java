package com.codeLearner.Ziganya.models.credittraitment;

import com.codeLearner.Ziganya.models.credit.CreditConverter;
import org.springframework.stereotype.Component;

@Component
public class CreditTraitmentConverter {

    private final CreditConverter creditConverter;

    public CreditTraitmentConverter(CreditConverter creditConverter) {
        this.creditConverter = creditConverter;
    }

    public CreditTraitmentResponse convertToResponse(CreditTraitment creditTraitment){
        CreditTraitmentResponse response = new CreditTraitmentResponse();
        response.setCredit(creditConverter.convertToResponse(creditTraitment.getCredit()));
        response.setDecision(creditTraitment.getDecision());
        response.setTraitmentDate(creditTraitment.getTraitmentDate());
        return  response;
    }

    public CreditTraitment convertToEntity(CreditTraitmentRequest request){
        CreditTraitment creditTraitment = new CreditTraitment();
        creditTraitment.setDecision(request.getDecision());
        creditTraitment.setTraitmentDate(request.getTraitmentDate());
        return creditTraitment;
    }
}
