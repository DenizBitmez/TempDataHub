package com.redis.tempdatahub.service.abstracts;

public interface VisitorCounterService {

    long incrementCounter(String page);

    long getCounter(String page);
}
