package com.codeLearner.Ziganya.models.credittreatment;

import java.util.List;

public interface CreditTraitmentService {

    public CreditTraitmentResponse createCreditTraitment(CreditTraitmentRequest request);

    public List<CreditTraitmentResponse> getAllCreditTraitments();
}
