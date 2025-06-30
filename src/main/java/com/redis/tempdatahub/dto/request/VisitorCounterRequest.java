package com.redis.tempdatahub.dto.request;

import jakarta.validation.constraints.NotBlank;
public class VisitorCounterRequest {
    @NotBlank(message = "Page cannot be empty")
    private String page;
    private int count;

    public VisitorCounterRequest(String page, int count) {
        this.page = page;
        this.count = count;
    }

    public VisitorCounterRequest() {

    }
    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
