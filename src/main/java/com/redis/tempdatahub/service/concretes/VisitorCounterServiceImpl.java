package com.redis.tempdatahub.service.concretes;

import com.redis.tempdatahub.service.abstracts.VisitorCounterService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class VisitorCounterServiceImpl implements VisitorCounterService {
    private final StringRedisTemplate redisTemplate;

    public VisitorCounterServiceImpl(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public long incrementCounter(String page) {
        return redisTemplate.opsForValue().increment(buildKey(page));
    }

    @Override
    public long getCounter(String page) {
        String value = redisTemplate.opsForValue().get(buildKey(page));
        return value != null ? Long.parseLong(value) :0L;
    }

    private String buildKey(String page){
        return "visitors:" + page.toLowerCase();
    }
}
