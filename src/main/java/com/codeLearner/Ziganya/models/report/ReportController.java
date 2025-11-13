package com.codeLearner.Ziganya.models.report;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reports")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/all-members")
    public ResponseEntity<List<ReportResponse>> getAllMembers(){
        List<ReportResponse> responses = reportService.getReport();
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @GetMapping("/general")
    public ResponseEntity<GeneralReportResponse> getGenenalReport(){
        GeneralReportResponse response = reportService.getGeneralReport();
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
