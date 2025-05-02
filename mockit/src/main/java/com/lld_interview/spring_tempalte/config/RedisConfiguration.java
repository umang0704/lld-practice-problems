package com.lld_interview.spring_tempalte.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
@ConditionalOnProperty(value = "redis.cache.enabled", havingValue = "true")
public class RedisConfiguration {

    @Value(value = "${redis.host}")
    private String redisHostName;
    @Value(value = "${redis.port}")
    private int redisPort;

    @Bean(name = "jedisConnectionFactory")
    private JedisConnectionFactory jedisConnectionFactory() {
        return new JedisConnectionFactory(getRedisStandaloneConfigurations());
    }

    @Bean(name = "redisStandAloneConfig")
    private RedisStandaloneConfiguration getRedisStandaloneConfigurations() {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName(redisHostName);
        redisStandaloneConfiguration.setPort(redisPort);
        return redisStandaloneConfiguration;
    }

    @Bean(name = "redisCacheTemplate")
    public RedisTemplate<String, Object> redisCacheTemplate() {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        return template;
    }
}
