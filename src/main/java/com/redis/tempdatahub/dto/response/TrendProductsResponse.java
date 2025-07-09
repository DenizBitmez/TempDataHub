package com.redis.tempdatahub.dto.response;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TrendProductsResponse {

    private String productId;
    private long views;

    public TrendProductsResponse(String value, long l) {

    }
}
