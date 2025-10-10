package com.codeLearner.Ziganya.models.refund;

import com.codeLearner.Ziganya.models.associationaccount.AssociationAccount;
import com.codeLearner.Ziganya.models.associationaccount.AssociationAccountRepository;
import com.codeLearner.Ziganya.models.credit.Credit;
import com.codeLearner.Ziganya.models.credit.CreditRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RefundServiceImpl implements RefundService{

    private final RefundRepository refundRepository;
    private final RefundConverter refundConverter;
    private final CreditRepository creditRepository;
    private final AssociationAccountRepository associationAccountRepository;

    public RefundServiceImpl(RefundRepository refundRepository, RefundConverter refundConverter, CreditRepository creditRepository, AssociationAccountRepository associationAccountRepository) {
        this.refundRepository = refundRepository;
        this.refundConverter = refundConverter;
        this.creditRepository = creditRepository;
        this.associationAccountRepository = associationAccountRepository;
    }

    @Transactional
    @Override
    public RefundResponse createRefund(RefundRequest request) {
        AssociationAccount associationAccount = associationAccountRepository.findCurrentAssociationAccount();
        Credit credit = creditRepository.findById(request.getCreditId()).orElseThrow(() -> new RuntimeException("Credit not found"));
        Refund refund = refundConverter.convertToEntity(request);
        refund.setCredit(credit);
        associationAccount.setCurrentAmount(associationAccount.getCurrentAmount()+ refund.getAmount());
        associationAccount.setLoanBalance(associationAccount.getLoanBalance()- refund.getAmount());
        associationAccountRepository.save(associationAccount);
        Refund savedRefund = refundRepository.save(refund);
        return refundConverter.convertToResponse(savedRefund);
    }

    @Override
    public List<RefundResponse> getAllRefunds() {
        return refundRepository.findAll().stream().map(refundConverter::convertToResponse).toList();
    }
}
