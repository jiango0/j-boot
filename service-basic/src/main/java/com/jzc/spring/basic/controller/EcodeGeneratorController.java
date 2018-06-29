package com.jzc.spring.basic.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toonyoo.common.ecodegenerator.service.EcodeGeneratorServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ecode")
public class EcodeGeneratorController {

    @Autowired
    EcodeGeneratorServcie ecodeGeneratorServcie;

    @Autowired
    RedisTemplate redisTemplate;

    @RequestMapping(value = "getCodeSeq")
    public String getCodeSeq() {
        int randomSize = 4;
        int seqSize = 4;
        int oddSize = 0;
        String code = ecodeGeneratorServcie.getCode("jzc", randomSize, seqSize, 100);

        StringBuffer stringBuffer = new StringBuffer();
        char[] chars = code.toCharArray();
        for(int i=0; i<code.length(); i++) {
            if( !this.whetherOdd(i) && oddSize < randomSize ) {
                oddSize++;
                continue;
            }
            stringBuffer.append(chars[i]);
        }
        System.out.println(stringBuffer.toString());

        RedisTemplate template = this.getRedisTemplate();
        template.execute(new SessionCallback<Long>() {

            @Override
            public Long execute(RedisOperations redisOperations) throws DataAccessException {
                BoundZSetOperations boundZSetOperations = redisOperations.boundZSetOps("code_zset");
                boundZSetOperations.add(Long.valueOf(code), new Double(stringBuffer.toString()) );
                return null;
            }

        });

        return code;
    }

    /**
     * 判断是否奇数
     * @param   num
     * @return
     * */
    public static boolean whetherOdd(int num) {
        return (num & 1) == 1;
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
