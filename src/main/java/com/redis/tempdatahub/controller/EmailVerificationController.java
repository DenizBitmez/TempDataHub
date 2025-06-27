package com.redis.tempdatahub.controller;

import com.redis.tempdatahub.dto.request.EmailVerificationRequest;
import com.redis.tempdatahub.dto.response.EmailVerificationResponse;
import com.redis.tempdatahub.service.abstracts.EmailVerificationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailVerificationController {
    private final EmailVerificationService emailVerificationService;

    public EmailVerificationController(EmailVerificationService emailVerificationService) {
        this.emailVerificationService = emailVerificationService;
    }

    @PostMapping("/send")
    public ResponseEntity<EmailVerificationResponse> send(@Valid @RequestBody EmailVerificationRequest emailVerificationRequest) {
        emailVerificationService.sendCode(emailVerificationRequest.getEmail());
        return ResponseEntity.ok(new EmailVerificationResponse(true,"Code Sent"));
    }

    @PostMapping("/verify")
    public ResponseEntity<EmailVerificationResponse> verify(@Valid @RequestBody EmailVerificationRequest emailVerificationRequest) {
        boolean result = emailVerificationService.verifyCode(emailVerificationRequest.getEmail(), emailVerificationRequest.getCode());
        return result
                ? ResponseEntity.ok(new EmailVerificationResponse(true, "Verification success"))
                : ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new EmailVerificationResponse(false, "Code invalid or expired."));
    }
}
