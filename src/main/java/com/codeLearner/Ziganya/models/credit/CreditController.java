package com.codeLearner.Ziganya.models.credit;

import com.codeLearner.Ziganya.util.DeleteOperationResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/credits")
public class CreditController {

    private final CreditService creditService;

    public CreditController(CreditService creditService) {
        this.creditService = creditService;
    }

    @PostMapping
    public ResponseEntity<CreditResponse> createCredit(@RequestBody CreditRequest request) {
        CreditResponse response = creditService.createCredit(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CreditResponse>> getAllCredits() {
        List<CreditResponse> response = creditService.getAllCredits();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CreditResponse> updateCredit(@PathVariable Long id, @RequestBody CreditRequest request) {
        CreditResponse response = creditService.updateCredit(id, request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteOperationResponse> deleteCredit(@PathVariable Long id) {
        DeleteOperationResponse response = creditService.deleteById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<List<CreditResponse>> getCreditByMemberId(@PathVariable Long memberId) {
        List<CreditResponse> response = creditService.getCreditByMemberId(memberId);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
