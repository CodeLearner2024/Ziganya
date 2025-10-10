package com.codeLearner.Ziganya.models.associationaccount;

import java.time.LocalDate;
import java.util.List;

public interface AssociationAccountService {

    public AssociationAccountResponse createAssociationAccount(AssociationAccountRequest request);

    public List<AssociationAccountResponse> getAllAssociationAccounts();

    public AssociationAccountResponse getAssociationAccountByPeriod(LocalDate cycleStartDate, LocalDate cycleEndDate);

    public AssociationAccountResponse getCurrentAssociationAccount();
}
