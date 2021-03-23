package com.haugv.controller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class RedisCommandController {

    @Resource
    RedisTemplate redisTemplate;

    @GetMapping("/redis/cmd/get")
    public String get(String key){
        return (String)redisTemplate.opsForValue().get("redis::"+key);
    }

    @GetMapping("/redis/cmd/set")
    public String set(String value){
        redisTemplate.opsForValue().set("redis::"+value, value);
        return "set value success";
    }
}
