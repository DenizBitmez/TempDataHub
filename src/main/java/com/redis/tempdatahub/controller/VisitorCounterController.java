package com.redis.tempdatahub.controller;

import com.redis.tempdatahub.dto.request.VisitorCounterRequest;
import com.redis.tempdatahub.dto.response.VisitorCounterResponse;
import com.redis.tempdatahub.service.abstracts.VisitorCounterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/visitor")
public class VisitorCounterController {

    private final VisitorCounterService visitorCounterService;

    public VisitorCounterController(VisitorCounterService visitorCounterService) {
        this.visitorCounterService = visitorCounterService;
    }

    @PostMapping
    public ResponseEntity<VisitorCounterResponse> visitor(@Valid @RequestBody VisitorCounterRequest visitorCounterRequest){
        int count = (int) visitorCounterService.incrementCounter(visitorCounterRequest.getPage());
        return ResponseEntity.ok(new VisitorCounterResponse(visitorCounterRequest.getPage(), count));
    }

    @GetMapping("/{page}")
    public ResponseEntity<VisitorCounterResponse> getVisitorCount(@PathVariable String page) {
        int count= (int) visitorCounterService.getCounter(page);
        return ResponseEntity.ok(new VisitorCounterResponse(page, count));
    }
}
