package com.redis.tempdatahub.service.abstracts;

import com.redis.tempdatahub.dto.request.EmailVerificationRequest;

public interface EmailVerificationService {
    boolean verifyCode(String email,String code);

    void sendCode(String email);
}
