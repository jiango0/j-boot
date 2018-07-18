package com.jzc.spring.basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "redis")
public class RedisController {

    @Autowired
    RedisTemplate redisTemplate;

    @RequestMapping(value = "setValue")
    public Integer setValue(String key, String value) {
        ValueOperations operations = redisTemplate.opsForValue();
        operations.set(key, value);
        return 1;
    }

}
