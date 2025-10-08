package com.codeLearner.Ziganya.models.credit;


import com.codeLearner.Ziganya.util.DeleteOperationResponse;

import java.util.List;

public interface CreditService {


    public CreditResponse createCredit(CreditRequest request);

    public List<CreditResponse> getAllCredits();

    public CreditResponse updateCredit(Long id, CreditRequest request);

    public List<CreditResponse> getCreditByMemberId(Long memberId);

    public DeleteOperationResponse deleteById(Long id);
}
