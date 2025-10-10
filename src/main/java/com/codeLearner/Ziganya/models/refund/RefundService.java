package com.codeLearner.Ziganya.models.refund;

import java.util.List;

public interface RefundService {

    public RefundResponse createRefund(RefundRequest request);

    public List<RefundResponse> getAllRefunds();


    

}
