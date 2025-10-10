package com.codeLearner.Ziganya.models.reporting;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reports")
public class ReportingController {

    private final ReportingService reportingService;

    public ReportingController(ReportingService reportingService) {
        this.reportingService = reportingService;
    }

    @GetMapping
    public ResponseEntity<ReportingResponse> getReport(){
        ReportingResponse response = reportingService.getReporting();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
