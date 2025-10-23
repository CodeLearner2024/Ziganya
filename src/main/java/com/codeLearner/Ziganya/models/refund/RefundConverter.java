package com.codeLearner.Ziganya.models.refund;

import com.codeLearner.Ziganya.models.credit.CreditConverter;
import org.springframework.stereotype.Component;

@Component
public class RefundConverter {

    private final CreditConverter creditConverter;

    public RefundConverter(CreditConverter creditConverter) {
        this.creditConverter = creditConverter;
    }

    public RefundResponse convertToResponse(Refund refund){
        RefundResponse response = new RefundResponse();
        response.setAmount(refund.getAmount());
        response.setId(refund.getId());
        response.setCredit(creditConverter.convertToResponse(refund.getCredit()));
        response.setRefundDate(refund.getRefundDate());
        return response;
    }

    public Refund convertToEntity(RefundRequest request){
        Refund refund = new Refund();
        refund.setAmount(request.getAmount());
        refund.setRefundDate(request.getRefundDate());
        return refund;
    }
}
