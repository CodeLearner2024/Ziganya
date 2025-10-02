package com.codeLearner.Ziganya.models.assotiationdetails;

import org.springframework.stereotype.Component;

@Component
public class AssociationDetailsConverter {

    public AssociationDetailsResponse converterToResponse(AssociationDetails associationDetails){
        AssociationDetailsResponse response = new AssociationDetailsResponse();
        response.setId(associationDetails.getId());
        response.setName(associationDetails.getName());
        response.setContact(associationDetails.getContact());
        response.setAddress(associationDetails.getAddress());
        response.setEmail(associationDetails.getEmail());
        response.setCycleStartDate(associationDetails.getCycleStartDate());
        response.setCycleEndDate(associationDetails.getCycleEndDate());
        return response;
    }


    public AssociationDetails converterToEntity(AssociationDetailsRequest request){
        AssociationDetails associationDetails = new AssociationDetails();
        associationDetails.setName(request.getName());
        associationDetails.setContact(request.getContact());
        associationDetails.setAddress(request.getAddress());
        associationDetails.setEmail(request.getEmail());
        associationDetails.setCycleStartDate(request.getCycleStartDate());
        associationDetails.setCycleEndDate(request.getCycleEndDate());
        return associationDetails;
    }
}
