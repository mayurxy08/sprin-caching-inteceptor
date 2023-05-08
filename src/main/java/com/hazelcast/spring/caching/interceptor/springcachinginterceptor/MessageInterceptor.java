package com.hazelcast.spring.caching.interceptor.springcachinginterceptor;

import com.hazelcast.map.MapInterceptor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessageInterceptor implements MapInterceptor {

    @Override
    public Object interceptGet(Object value) {
        return null;
    }

    @Override
    public void afterGet(Object value) {
    }

    @Override
    public Object interceptPut(Object oldValue, Object newValue) {
        return null;
    }

    @Override
    public void afterPut(Object value) {
        log.info("a new message: "+ value + " added to the cache");
    }

    @Override
    public Object interceptRemove(Object removedValue) {
        return null;
    }

    @Override
    public void afterRemove(Object oldValue) {
    }
    
}