package com.lld_interview.spring_tempalte.services.impl;

import com.lld_interview.spring_tempalte.services.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class CacheServiceImpl implements CacheService {
    private final RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public CacheServiceImpl(
            @Qualifier("redisCacheTemplate") RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public <T> T setValueToRedis(String key, T data, long ttl) {
        return null;
    }

    @Override
    public <T> T getValueFromCache(String key, Class<T> classType) {
        return null;
    }
}
