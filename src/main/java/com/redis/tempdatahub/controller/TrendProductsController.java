package com.redis.tempdatahub.controller;

import com.redis.tempdatahub.dto.request.TrendProductsRequest;
import com.redis.tempdatahub.dto.response.TrendProductsResponse;
import com.redis.tempdatahub.service.abstracts.TrendProductsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TrendProductsController {
    private final TrendProductsService trendProductsService;

    public TrendProductsController(TrendProductsService trendProductsService) {
        this.trendProductsService = trendProductsService;
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addView(@RequestBody TrendProductsRequest trendProductsRequest){
        trendProductsService.incrementProductViews(trendProductsRequest.getProductId());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/top")
    public ResponseEntity<List<TrendProductsResponse>> topView(@RequestParam(defaultValue = "10") int count){
        return ResponseEntity.ok(trendProductsService.getTopTrending(count));
    }
}
