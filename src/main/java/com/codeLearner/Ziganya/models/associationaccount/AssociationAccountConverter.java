package com.codeLearner.Ziganya.models.associationaccount;

import org.springframework.stereotype.Component;

@Component
public class AssociationAccountConverter {

    public AssociationAccountResponse convertToResponse(AssociationAccount associationAccount){
        AssociationAccountResponse response = new AssociationAccountResponse();
        response.setCurrentAmount(associationAccount.getCurrentAmount());
        response.setLoanBalance(associationAccount.getLoanBalance());
        response.setTotalAmount(associationAccount.getTotalAmount());
        return response;
    }

    public AssociationAccount convertToEntity(AssociationAccountRequest request){
        AssociationAccount associationAccount = new AssociationAccount();
        associationAccount.setCurrentAmount(request.getCurrentAmount());
        associationAccount.setLoanBalance(request.getLoanBalance());
        associationAccount.setTotalAmount(request.getTotalAmount());
        return associationAccount;
    }
}
