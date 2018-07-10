package com.jzc.spring.basic.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jzc.spring.basic.service.EcodeGenService;
import com.jzc.spring.basic.service.EcodeService;
import com.toonyoo.common.ecodegenerator.scan.EcodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.BoundZSetOperations;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ecode")
public class EcodeGeneratorController {

    @Autowired
    EcodeService ecodeService;

    @Autowired
    RedisTemplate redisTemplate;

    @RequestMapping(value = "getCodeSeq")
    public String getCodeSeq() {
        int randomSize = 1;
        String codePattern = "RRRR123456";
        String code = ecodeService.getCode("jzc", codePattern);
        StringBuffer stringBuffer = new StringBuffer();
        char[] chars = code.toCharArray();
        int i = 1;
        while (codePattern.indexOf(String.valueOf(i)) != -1 ) {
            stringBuffer.append(chars[codePattern.indexOf(String.valueOf(i))]);
            i++;
        }

        System.out.println(stringBuffer.toString());

        RedisTemplate template = this.getRedisTemplate();
        template.execute(new SessionCallback<Long>() {

            @Override
            public Long execute(RedisOperations redisOperations) throws DataAccessException {
                BoundZSetOperations boundZSetOperations = redisOperations.boundZSetOps("code_zset");
                Boolean addFlag = boundZSetOperations.add(Long.valueOf(code), new Double(stringBuffer.toString()));

                if(!addFlag) {
                    BoundZSetOperations failOperations = redisOperations.boundZSetOps("code_zset_fail");
                    failOperations.add(Long.valueOf(code), new Double(stringBuffer.toString()));
                }

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
