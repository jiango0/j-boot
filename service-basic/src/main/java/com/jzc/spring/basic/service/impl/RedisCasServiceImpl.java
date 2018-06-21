package com.jzc.spring.basic.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jzc.spring.basic.service.RedisCasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class RedisCasServiceImpl implements RedisCasService {

    @Autowired
    RedisTemplate redisTemplate;

    private AtomicInteger failCount = new AtomicInteger();

    public void deduction(Long num) {
        String key = "das-num";

        RedisTemplate template = this.getRedisTemplate();
        template.execute(new SessionCallback<Long>() {
            @Override
            public Long execute(RedisOperations redisOperations) throws DataAccessException {
                BoundValueOperations<String, Long> operations = redisOperations.boundValueOps(key);
                if(!redisOperations.hasKey(key)) {
                    operations.setIfAbsent(1000L);
                }
                return null;
            }
        });
        template.execute(new SessionCallback<Long>() {
            @Override
            public Long execute(RedisOperations redisOperations) throws DataAccessException {
                ValueOperations<String, Long> operations = redisOperations.opsForValue();
                while (true) {
                    redisOperations.watch(key);
                    Long value = operations.get(key);
                    if(value > 0) {
                        redisOperations.multi();
                        operations.increment(key, -1L);
                        List exec = redisOperations.exec();
                        if(!CollectionUtils.isEmpty(exec)) {
                            break;
                        }
                        int i = failCount.addAndGet(1);
                        System.out.println(i);
                    } else {
                        break;
                    }
                }
                return null;
            }
        });

    }

    private RedisTemplate getRedisTemplate() {
        RedisSerializer stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Long.class);
        ObjectMapper objectMapper = new ObjectMapper();
        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);

        return redisTemplate;
    }

}
