package com.codeLearner.Ziganya.models.assotiationdetails;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/association-details")
public class AssociationDetailsController {


    private final AssociationDetailsService associationDetailsService;

    public AssociationDetailsController(AssociationDetailsService associationDetailsService) {
        this.associationDetailsService = associationDetailsService;
    }

    @PostMapping
    public ResponseEntity<AssociationDetailsResponse> addAssociationDetails(AssociationDetailsRequest associationDetailsRequest){
        AssociationDetailsResponse response = associationDetailsService.addAssociationDetails(associationDetailsRequest);
        return  new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<AssociationDetailsResponse> getAssociationDetails(){
        AssociationDetailsResponse response = associationDetailsService.getAssociationDetails();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
