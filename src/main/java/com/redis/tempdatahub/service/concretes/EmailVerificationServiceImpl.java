package com.redis.tempdatahub.service.concretes;

import com.redis.tempdatahub.service.abstracts.EmailVerificationService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Random;

@Service
public class EmailVerificationServiceImpl implements EmailVerificationService {

    private final StringRedisTemplate redisTemplate;

    public EmailVerificationServiceImpl(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void sendCode(String email){
        String code = generateCode();
        redisTemplate.opsForValue().set(buildRedisKey(email),code, Duration.ofMinutes(5));
        System.out.println("Send code:"+ code + " (email: " + email + ")");
    }

    @Override
    public boolean verifyCode(String email,String code) {
        String key = buildRedisKey(email);
        String storedCode = redisTemplate.opsForValue().get(key);
        return storedCode != null && storedCode.equals(code);
    }

    private String generateCode(){
        int num = new Random().nextInt(1_000_000);
        return String.format("%06d", num);
    }

    private String buildRedisKey(String email){
        return "verify:" + email.toLowerCase();
    }
}
