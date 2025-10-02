package com.codeLearner.Ziganya.models.assotiationdetails;

import com.codeLearner.Ziganya.i18n.I18nConstants;
import com.codeLearner.Ziganya.i18n.I18nConstantsInjectedMessages;
import com.codeLearner.Ziganya.exceptionhandling.exception.UnsupportedOperationException;
import org.springframework.stereotype.Service;

@Service
public class AssociationDetailsServiceImpl implements AssociationDetailsService{
    private final AssociationDetailsRepository associationDetailsRepository;
    private final AssociationDetailsConverter associationDetailsConverter;

    public AssociationDetailsServiceImpl(AssociationDetailsRepository associationDetailsRepository, AssociationDetailsConverter associationDetailsConverter) {
        this.associationDetailsRepository = associationDetailsRepository;
        this.associationDetailsConverter = associationDetailsConverter;
    }

    @Override
    public AssociationDetailsResponse addAssociationDetails(AssociationDetailsRequest associationDetailsRequest) {
        AssociationDetails associationDetails = associationDetailsConverter.converterToEntity(associationDetailsRequest);
        associationDetails.setId(1L);
        if(associationDetailsRequest.getName().isBlank()){
            throw new UnsupportedOperationException(I18nConstantsInjectedMessages.NO_ASSOCIATION_BLANK_NAME_KEY,I18nConstants.NO_ASSOCIATION_BLANK_NAME,I18nConstants.NO_ASSOCIATION_BLANK_NAME);
        }
        AssociationDetails savedAssociationDetails = associationDetailsRepository.save(associationDetails);
        return associationDetailsConverter.converterToResponse(savedAssociationDetails);
    }

    @Override
    public AssociationDetailsResponse getAssociationDetails() {
        AssociationDetails associationDetails = associationDetailsRepository.findAll().stream().findFirst().orElseThrow(() -> new UnsupportedOperationException(I18nConstantsInjectedMessages.ELEMENT_NOT_FOUND_KEY, I18nConstants.ELEMENT_NOT_FOUND,I18nConstants.ELEMENT_NOT_FOUND));
        return associationDetailsConverter.converterToResponse(associationDetails);
    }
}
