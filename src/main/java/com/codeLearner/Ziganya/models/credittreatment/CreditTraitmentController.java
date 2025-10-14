package com.codeLearner.Ziganya.models.credittreatment;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/credit-traitment")
public class CreditTraitmentController {


    private final CreditTraitmentService creditTraitmentService;

    public CreditTraitmentController(CreditTraitmentService creditTraitmentService) {
        this.creditTraitmentService = creditTraitmentService;
    }

    @PostMapping
    public ResponseEntity<CreditTraitmentResponse> createCreditTraitment(@Valid @RequestBody CreditTraitmentRequest request){
        CreditTraitmentResponse response = creditTraitmentService.createCreditTraitment(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CreditTraitmentResponse>> getAllCreditTraitments(){
        List<CreditTraitmentResponse> response = creditTraitmentService.getAllCreditTraitments();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
