package com.oreuda.oreuda_auth.api.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    private final RedisTemplate<String, String> redisTemplate;

    public String get(String key) {
        String value = redisTemplate.opsForValue().get(key);
        if (value == null) return null;
        return value.replace("\"", "");
    }

    public void set(String key, String value) {
        String parsedValue = "\"" + value + "\"";
        redisTemplate.opsForValue().set(key, parsedValue);
    }

    public Long getExpire(String key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    public void setExpire(String key, Long time) {
        redisTemplate.expire(key, time, TimeUnit.SECONDS);
    }
}
