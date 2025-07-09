package com.redis.tempdatahub.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TrendProductsRequest {

    @NotBlank
    private String productId;
}
