package com.redis.tempdatahub.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class EmailVerificationRequest {
    @Email(message = "Please enter a valid email address.")
    @NotBlank(message = "Email cannot be empty")
    private String email;
    private String code;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public EmailVerificationRequest(String email, String code) {
        this.email = email;
        this.code = code;
    }

    public EmailVerificationRequest() {}
}
