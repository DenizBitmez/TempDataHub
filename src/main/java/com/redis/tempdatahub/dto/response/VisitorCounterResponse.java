package com.redis.tempdatahub.dto.response;

import jakarta.validation.constraints.NotBlank;
public class VisitorCounterResponse {
    @NotBlank(message = "Page cannot be empty")
    private String page;
    private int count;

    public VisitorCounterResponse(String page, int count) {
        this.page = page;
        this.count = count;
    }

    public VisitorCounterResponse() {

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

