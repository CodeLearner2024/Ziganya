package com.codeLearner.Ziganya.models.associationaccount;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/association-account")
public class AssociationAccountController {

    private final AssociationAccountService associationAccountService;

    public AssociationAccountController(AssociationAccountService associationAccountService) {
        this.associationAccountService = associationAccountService;
    }

    @GetMapping("/get-account-by-period")
    public ResponseEntity<AssociationAccountResponse> getAssociationAccountByPeriod(@RequestParam LocalDate cycleStartDate, @RequestParam LocalDate cycleEndDate) {
        return ResponseEntity.ok(this.associationAccountService.getAssociationAccountByPeriod(cycleStartDate, cycleEndDate));
    }

    @PostMapping(path = "/create-account")
    public ResponseEntity<AssociationAccountResponse> createAssociationAccount(AssociationAccountRequest request) {
        AssociationAccountResponse associationAccountResponse = this.associationAccountService.createAssociationAccount(request);
        return new ResponseEntity<>(associationAccountResponse, HttpStatus.CREATED);
    }

    @GetMapping("/get-all-accounts")
    public ResponseEntity<List<AssociationAccountResponse>> getAllAssociationAccounts() {
        List<AssociationAccountResponse> associationAccountResponse = this.associationAccountService.getAllAssociationAccounts();
        return new ResponseEntity<>(associationAccountResponse, HttpStatus.OK);
    }
}
