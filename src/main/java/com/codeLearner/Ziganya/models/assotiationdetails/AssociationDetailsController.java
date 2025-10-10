package com.codeLearner.Ziganya.models.assotiationdetails;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/association-details")
public class AssociationDetailsController {


    private final AssociationDetailsService associationDetailsService;

    public AssociationDetailsController(AssociationDetailsService associationDetailsService) {
        this.associationDetailsService = associationDetailsService;
    }

    @PostMapping
    public ResponseEntity<AssociationDetailsResponse> addAssociationDetails(@Valid @RequestBody AssociationDetailsRequest associationDetailsRequest){
        AssociationDetailsResponse response = associationDetailsService.addAssociationDetails(associationDetailsRequest);
        return  new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<AssociationDetailsResponse> getAssociationDetails(){
        AssociationDetailsResponse response = associationDetailsService.getAssociationDetails();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
