package com.codeLearner.Ziganya.models.credittreatment;

import com.codeLearner.Ziganya.exceptionhandling.exception.UnsupportedOperationException;
import com.codeLearner.Ziganya.i18n.I18nConstants;
import com.codeLearner.Ziganya.i18n.I18nConstantsInjectedMessages;
import com.codeLearner.Ziganya.models.associationaccount.AssociationAccount;
import com.codeLearner.Ziganya.models.associationaccount.AssociationAccountRepository;
import com.codeLearner.Ziganya.models.credit.Credit;
import com.codeLearner.Ziganya.models.credit.CreditRepository;
import com.codeLearner.Ziganya.models.enums.Decision;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditTraitmentServiceImpl implements CreditTraitmentService {

    private final CreditTraitmentRepository creditTraitmentRepository;
    private final CreditTraitmentConverter creditTraitmentConverter;
    private final CreditRepository creditRepository;
    private final AssociationAccountRepository associationAccountRepository;


    public CreditTraitmentServiceImpl(CreditTraitmentRepository creditTraitmentRepository, CreditTraitmentConverter creditTraitmentConverter, CreditRepository creditRepository, AssociationAccountRepository associationAccountRepository) {
        this.creditTraitmentRepository = creditTraitmentRepository;
        this.creditTraitmentConverter = creditTraitmentConverter;
        this.creditRepository = creditRepository;
        this.associationAccountRepository = associationAccountRepository;
    }


    @Override
    public CreditTraitmentResponse createCreditTraitment(CreditTraitmentRequest request) {
        CreditTraitment creditTraitment = creditTraitmentConverter.convertToEntity(request);
        Credit credit = creditRepository.findById(request.getCreditId()).orElseThrow(() -> new UnsupportedOperationException(I18nConstantsInjectedMessages.CREDIT_NOT_FOUND_KEY, I18nConstants.CREDIT_NOT_FOUND, I18nConstants.CREDIT_NOT_FOUND));
        creditTraitment.setCredit(credit);
        AssociationAccount associationAccount = associationAccountRepository.findCurrentAssociationAccount();
        if (associationAccount.getCurrentAmount() < credit.getAmount()) {
            throw new UnsupportedOperationException(I18nConstantsInjectedMessages.INSUFFICIENT_BALANCE_KEY, I18nConstants.INSUFFICIENT_BALANCE, I18nConstants.INSUFFICIENT_BALANCE);
        }
        if (request.getDecision() == Decision.GRANTED) {
            associationAccount.setCurrentAmount(associationAccount.getCurrentAmount() - credit.getAmount());
            associationAccount.setLoanBalance(associationAccount.getLoanBalance() + credit.getAmount());
            associationAccount.setInterestAmount(associationAccount.getInterestAmount() + (credit.getAmount() * credit.getInterestRate() / 100));
            associationAccountRepository.save(associationAccount);
            credit.setCreditDecision(Decision.GRANTED);
            double interestAmount = credit.getAmount() * credit.getInterestRate() / 100;
            credit.setTotalToPay(interestAmount + credit.getAmount());
            creditRepository.save(credit);
        }
        if (request.getDecision() == Decision.REFUSED) {
            credit.setCreditDecision(Decision.REFUSED);
            creditRepository.save(credit);
        }
        associationAccountRepository.save(associationAccount);
        CreditTraitment savedCreditTraitment = creditTraitmentRepository.save(creditTraitment);
        return creditTraitmentConverter.convertToResponse(savedCreditTraitment);
    }

    @Override
    public List<CreditTraitmentResponse> getAllCreditTraitments() {
        return creditTraitmentRepository.findAll().stream().map(creditTraitmentConverter::convertToResponse).toList();
    }
}
