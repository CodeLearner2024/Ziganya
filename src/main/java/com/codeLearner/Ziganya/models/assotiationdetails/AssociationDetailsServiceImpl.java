package com.codeLearner.Ziganya.models.assotiationdetails;

import com.codeLearner.Ziganya.i18n.I18nConstants;
import com.codeLearner.Ziganya.i18n.I18nConstantsInjectedMessages;
import com.codeLearner.Ziganya.exceptionhandling.exception.UnsupportedOperationException;
import com.codeLearner.Ziganya.models.associationaccount.AssociationAccount;
import com.codeLearner.Ziganya.models.associationaccount.AssociationAccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AssociationDetailsServiceImpl implements AssociationDetailsService{
    private final AssociationDetailsRepository associationDetailsRepository;
    private final AssociationDetailsConverter associationDetailsConverter;
    private final AssociationAccountRepository associationAccountRepository;

    public AssociationDetailsServiceImpl(AssociationDetailsRepository associationDetailsRepository, AssociationDetailsConverter associationDetailsConverter, AssociationAccountRepository associationAccountRepository) {
        this.associationDetailsRepository = associationDetailsRepository;
        this.associationDetailsConverter = associationDetailsConverter;
        this.associationAccountRepository = associationAccountRepository;
    }

    @Override
    public AssociationDetailsResponse addAssociationDetails(AssociationDetailsRequest associationDetailsRequest) {
        AssociationDetails associationDetails = associationDetailsConverter.converterToEntity(associationDetailsRequest);
        associationDetails.setId(1L);
        if(associationDetailsRequest.getName().isBlank()){
            throw new UnsupportedOperationException(I18nConstantsInjectedMessages.NO_ASSOCIATION_BLANK_NAME_KEY,I18nConstants.NO_ASSOCIATION_BLANK_NAME,I18nConstants.NO_ASSOCIATION_BLANK_NAME);
        }
        AssociationAccount associationAccount = new AssociationAccount();
        associationAccount.setCurrentAmount(0.0);
        associationAccount.setLoanBalance(0.0);
        associationAccount.setCycleStartDate(associationDetailsRequest.getCycleStartDate());
        associationAccount.setCycleEndDate(associationDetailsRequest.getCycleEndDate());
        associationAccountRepository.save(associationAccount);
        AssociationDetails savedAssociationDetails = associationDetailsRepository.save(associationDetails);
        return associationDetailsConverter.converterToResponse(savedAssociationDetails);
    }

    @Override
    public AssociationDetailsResponse getAssociationDetails() {
        AssociationDetails associationDetails = associationDetailsRepository.findAll().stream().findFirst().orElseThrow(() -> new UnsupportedOperationException(I18nConstantsInjectedMessages.ELEMENT_NOT_FOUND_KEY, I18nConstants.ELEMENT_NOT_FOUND,I18nConstants.ELEMENT_NOT_FOUND));
        return associationDetailsConverter.converterToResponse(associationDetails);
    }
}
