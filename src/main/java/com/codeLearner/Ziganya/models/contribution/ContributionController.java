package com.codeLearner.Ziganya.models.contribution;

import com.codeLearner.Ziganya.util.DeleteOperationResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contributions")
public class ContributionController {

    private final ContributionService contributionService;

    public ContributionController(ContributionService contributionService) {
        this.contributionService = contributionService;
    }

    @PostMapping
    public ResponseEntity<ContributionResponse> createContribution(@Valid @RequestBody ContributionRequest request) {
        ContributionResponse contributionResponse = contributionService.createContribution(request);
        return new ResponseEntity<>(contributionResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ContributionResponse>> getAllContributions() {
        List<ContributionResponse> contributionResponse = contributionService.getAllContributions();
        return new ResponseEntity<>(contributionResponse, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ContributionResponse> updateContribution(@PathVariable Long id, @RequestBody ContributionRequest request) {
        ContributionResponse contributionResponse = contributionService.updateContribution(id, request);
        return new ResponseEntity<>(contributionResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteOperationResponse> deleteContribution(@PathVariable Long id) {
        DeleteOperationResponse response = contributionService.deleteContribution(id);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}
