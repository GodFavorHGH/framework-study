package com.haugv.utils;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Pipeline;

import javax.annotation.Resource;
import java.util.Map;

@Component
public class RedisCacheUtil {

    @Resource
    RedisTemplate redisTemplate;

//    @Resource
//    Pipeline pipeline;

    public void set(String key, String value){
        redisTemplate.opsForValue().set(key, value);
    }

    public String get(String key){
        return (String)redisTemplate.opsForValue().get(key);
    }

    public void hsetAll(String key, Map set){
        redisTemplate.opsForHash().putAll(key, set);
    }


    public void hgetAll(String setKey, String propKey){
        System.out.println(redisTemplate.opsForHash().get(setKey, propKey));
    }
}
