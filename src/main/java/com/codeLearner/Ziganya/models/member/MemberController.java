package com.codeLearner.Ziganya.models.member;

import com.codeLearner.Ziganya.util.DeleteOperationResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    public ResponseEntity<MemberResponse> createMember(@Valid @RequestBody MemberRequest request) {
        MemberResponse memberResponse = memberService.createMember(request);
        return  new ResponseEntity<>(memberResponse, HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<MemberResponse>> getAllMembers() {
        List<MemberResponse> memberResponse = memberService.getAllMembers();
        return new ResponseEntity<>(memberResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberResponse> getMemberById(@PathVariable Long id) {
        MemberResponse memberResponse = memberService.getMemberById(id);
        return new ResponseEntity<>(memberResponse, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MemberResponse> updateMember(@PathVariable Long id, @RequestBody MemberRequest request) {
        MemberResponse memberResponse = memberService.updateMember(id, request);
        return new ResponseEntity<>(memberResponse, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteOperationResponse> deleteMember(@PathVariable Long id) {
        DeleteOperationResponse response = memberService.deleteMember(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
