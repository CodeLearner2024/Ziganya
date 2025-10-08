package com.codeLearner.Ziganya.models.credittraitment;

import com.codeLearner.Ziganya.exceptionhandling.exception.UnsupportedOperationException;
import com.codeLearner.Ziganya.i18n.I18nConstants;
import com.codeLearner.Ziganya.i18n.I18nConstantsInjectedMessages;
import com.codeLearner.Ziganya.models.associationaccount.AssociationAccountRepository;
import com.codeLearner.Ziganya.models.credit.Credit;
import com.codeLearner.Ziganya.models.credit.CreditRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class CreditTraitmentServiceImpl implements CreditTraitmentService{

    private final CreditTraitmentRepository creditTraitmentRepository;;
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
        Credit credit = creditRepository.findById(request.getCreditId()).orElseThrow(() -> new UnsupportedOperationException(I18nConstantsInjectedMessages.CREDIT_NOT_FOUND_KEY, I18nConstants.CREDIT_NOT_FOUND,I18nConstants.CREDIT_NOT_FOUND));
        CreditTraitment savedCreditTraitment = creditTraitmentRepository.save(creditTraitment);
        return creditTraitmentConverter.convertToResponse(savedCreditTraitment);
    }

    @Override
    public List<CreditTraitmentResponse> getAllCreditTraitments() {
        return creditTraitmentRepository.findAll().stream().map(creditTraitmentConverter::convertToResponse).toList();
    }
}
