package com.codeLearner.Ziganya.models.refund;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/refunds")
public class RefundController {

    private final RefundService refundService;

    public RefundController(RefundService refundService) {
        this.refundService = refundService;
    }

    @PostMapping
    public ResponseEntity<RefundResponse> createRefund(RefundRequest request){
        RefundResponse response = refundService.createRefund(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RefundResponse>> getAllRefunds(){
        List<RefundResponse> response = refundService.getAllRefunds();
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
