package com.redis.tempdatahub.service.abstracts;

import com.redis.tempdatahub.dto.response.TrendProductsResponse;

import java.util.List;

public interface TrendProductsService {

    void incrementProductViews(String productId);

    List<TrendProductsResponse> getTopTrending(int count);
}
