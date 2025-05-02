package com.lld_interview.spring_tempalte.services;

/**
 * The interface Cache service.
 */
public interface CacheService {
    /**
     * Sets value to redis.
     *
     * @param <T>  the type parameter
     * @param key  the key
     * @param data the data
     * @param ttl  the ttl
     * @return the value to redis
     */
    <T> T setValueToRedis(String key, T data, long ttl);

    /**
     * Gets value from cache.
     *
     * @param <T>       the type parameter
     * @param key       the key
     * @param classType the class type
     * @return the value from cache
     */
    <T> T getValueFromCache(String key, Class<T> classType);
}
