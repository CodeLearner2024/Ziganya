package com.codeLearner.Ziganya.models.refund;

import com.codeLearner.Ziganya.exceptionhandling.exception.UnsupportedOperationException;
import com.codeLearner.Ziganya.i18n.I18nConstants;
import com.codeLearner.Ziganya.i18n.I18nConstantsInjectedMessages;
import com.codeLearner.Ziganya.models.associationaccount.AssociationAccount;
import com.codeLearner.Ziganya.models.associationaccount.AssociationAccountRepository;
import com.codeLearner.Ziganya.models.credit.Credit;
import com.codeLearner.Ziganya.models.credit.CreditRepository;
import com.codeLearner.Ziganya.models.enums.Decision;
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
        if(!credit.getCreditDecision().equals(Decision.GRANTED)){
            throw new UnsupportedOperationException(I18nConstantsInjectedMessages.CREDIT_NOT_GRANTED_KEY, I18nConstants.CREDIT_NOT_GRANTED,I18nConstants.CREDIT_NOT_GRANTED);
        }
        List<Refund> refundList = refundRepository.findAllByCreditId(request.getCreditId());
        double totalRefunded = refundList.stream().mapToDouble(Refund::getAmount).sum();
        double interest = credit.getAmount()*credit.getInterestRate();
        if ((totalRefunded+request.getAmount()) > (credit.getAmount()+interest)){
            throw new UnsupportedOperationException(I18nConstantsInjectedMessages.STAYED_AMOUNT_TO_REFUND_KEY,I18nConstants.STAYED_AMOUNT_TO_REFUND,I18nConstants.STAYED_AMOUNT_TO_REFUND);
        }

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
