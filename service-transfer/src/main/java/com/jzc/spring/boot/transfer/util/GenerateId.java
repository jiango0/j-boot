package com.jzc.spring.boot.transfer.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Triple;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * id构造
 * 〈功能详细描述〉
 *
 * @author xiachao
 * @version [V1.0, 2019-05-09]
 */
@Component
@Slf4j
public class GenerateId {

    private static final String KEY_FORMAT = "gid_generator_%s";

    private static StringRedisTemplate stringRedisTemplate;

    private static RedisTemplate redisTemplate;

    /***
     * 根据前缀创建一个id
     * @param prefix
     * @return
     * @throws Exception
     */
    public static String getId(String prefix) {
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        String key = prefix + "_" + date;
        Long maxValue = 999L;
        Long increment = redisTemplate.opsForValue().increment(key, 1);
        if (increment.equals(1L)) {
            redisTemplate.expire(key, 1, TimeUnit.DAYS);
        }
        if (maxValue.compareTo(increment) < 0) {
            throw new RuntimeException("已超过最大数据值，不可创建");
        }
        return prefix + (Long.valueOf(date) * 1000 + increment);
    }

    /***
     * 根据前缀创建一个id
     * @param prefix
     * @return
     * @throws Exception
     */
    public static void revertId(String prefix) {
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        String key = prefix + "_" + date;
        redisTemplate.opsForValue().increment(key, -1);
    }

    /**
     * 无门店生成id
     */
    public static String nextId() {
        //String bizType, String bizItem
        //, bizType, bizItem);
        return nextId("00000000-0000-0000-0000-000000000000");
    }

    /**
     * 带门店生成id
     */
    public static String nextId(String shopId) {//, String bizType, String bizItem
        if (StringUtils.isEmpty(shopId)) {
            throw new RuntimeException("门店id不能为空");
        }

        if (shopId.length() < 32) {
            throw new RuntimeException("无效的门店id");
        }

        short gene;
        try {
            gene = (short) (Integer.parseInt(shopId.substring(0, 4), 16) + Short.MIN_VALUE);
        } catch (Exception e) {
            log.error(">>> call nextId error", e);
            throw new RuntimeException("生成id异常");
        }

        int currentTime = (int) (System.currentTimeMillis() / 1000);
        String key = String.format(KEY_FORMAT, currentTime);

        long seq = stringRedisTemplate.boundValueOps(key).increment(1);
        long ttl = Optional.ofNullable(stringRedisTemplate.boundValueOps(key).getExpire()).orElse(-1L);
        if (ttl <= 0) {
            // 避免多台机器时钟误差过大
            stringRedisTemplate.boundValueOps(key).expire(10, TimeUnit.MINUTES);
        }

        BigInteger bi = makeId(currentTime, (short) seq, gene);
        // + bizType + bizItem;
        return bi.toString();
    }

    /**
     * 解析id 解析出时间戳,序号,门店id基因
     */
    public static Triple<Long, Short, String> parseId(String id) {
        try {
            BigInteger bi = new BigInteger(id);
            byte[] bytes = bi.toByteArray();
            if(bytes.length>8){
                throw new RuntimeException("解析id异常");
            }
            ByteBuffer buffer = ByteBuffer.wrap(bytes);
            int time = buffer.getInt();
            short seq = buffer.getShort();
            short gene = buffer.getShort();
            return Triple.of(time * 1000L, seq, String.format("%04x",gene - Short.MIN_VALUE));
        } catch (Exception e) {
            throw new RuntimeException("解析id异常");
        }
    }

    private static BigInteger makeId(int currentTime, short seq, short gene) {
        ByteBuffer buffer = ByteBuffer.allocate(8);
        buffer.putInt(currentTime);
        buffer.putShort(seq);
        buffer.putShort(gene);
        return new BigInteger(buffer.array());
    }

    @Resource
    public void setStringRedisTemplate(StringRedisTemplate stringRedisTemplate) {
        GenerateId.stringRedisTemplate = stringRedisTemplate;
    }

    @Resource
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        GenerateId.redisTemplate = redisTemplate;
    }
}
