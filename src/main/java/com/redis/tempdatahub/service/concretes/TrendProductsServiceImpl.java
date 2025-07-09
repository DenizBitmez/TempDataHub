package com.redis.tempdatahub.service.concretes;

import com.redis.tempdatahub.dto.response.TrendProductsResponse;
import com.redis.tempdatahub.service.abstracts.TrendProductsService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TrendProductsServiceImpl implements TrendProductsService {

    private final StringRedisTemplate redisTemplate;
    private static final String KEY = "trending:products";

    public TrendProductsServiceImpl(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void incrementProductViews(String productId){
        redisTemplate.opsForZSet().incrementScore(KEY,productId,1);
    }

    @Override
    public List<TrendProductsResponse> getTopTrending(int count){
        Set<ZSetOperations.TypedTuple<String>> topProducts =
                redisTemplate.opsForZSet().reverseRangeWithScores(KEY,0,count-1);

        if (topProducts == null)
            return Collections.emptyList();

        return topProducts.stream()
                .map(tuple -> new TrendProductsResponse(tuple.getValue(), tuple.getScore().longValue()))
                .collect(Collectors.toList());
    }
}
