package com.jzc.spring.boot.wechat.test.impl;

import com.alibaba.fastjson.JSONObject;
import com.jzc.spring.boot.wechat.test.AppletUserRedisService;
import com.jzc.spring.boot.wechat.test.domain.UserInfoDTO;
import com.jzc.spring.boot.wechat.test.utils.SecurityContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.security.MessageDigest;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class AppletUserRedisServiceImpl implements AppletUserRedisService {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    private String tokenKeyPrefix = "wechat:token:";

    private String codeKeyPrefix = "wechat:code:";

    private String formKeyPrefix = "wechat:form:";

    @Override
    public void setSecurityContext(UserInfoDTO userInfoDTO) {
        SecurityContext securityContext = new SecurityContext();
        securityContext.setMemberId(userInfoDTO.getMemberId());
        securityContext.setOpenId(userInfoDTO.getOpenId());
        securityContext.setUnionId(userInfoDTO.getUnionId());
        securityContext.setNickName(userInfoDTO.getNickName());
        securityContext.setPartnerSign(userInfoDTO.getPartnerSign());
        securityContext.setMerchantId(userInfoDTO.getMerchantId());
        //生成token
        String token = md5(userInfoDTO.getOpenId() + UUID.randomUUID());
        userInfoDTO.setToken(token);

        ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
        stringStringValueOperations.set(tokenKeyPrefix + token, JSONObject.toJSONString(securityContext), 30, TimeUnit.DAYS);
    }

    @Override
    public String getSecurityContext(String token) {
        ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
        return stringStringValueOperations.get(tokenKeyPrefix + token);
    }

    @Override
    public void setMemberCode(String memberId, String code) {
        ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
        stringStringValueOperations.set(codeKeyPrefix + "code_" + code, memberId, 70, TimeUnit.SECONDS);
        stringStringValueOperations.set(codeKeyPrefix + "memberId_" + memberId, code, 70, TimeUnit.SECONDS);
    }

    @Override
    public void deleteMemberCode(String memberId, String code) {
        if (!StringUtils.isEmpty(memberId)) {
            stringRedisTemplate.delete(codeKeyPrefix + "memberId_" + memberId);
        }
        if (!StringUtils.isEmpty(code)) {
            stringRedisTemplate.delete(codeKeyPrefix + "code_" + code);
        }
    }

    @Override
    public String getCode(String memberId) {
        ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
        return stringStringValueOperations.get(codeKeyPrefix + "memberId_" + memberId);
    }

    @Override
    public String getMemberId(String code) {
        ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
        return stringStringValueOperations.get(codeKeyPrefix + "code_" + code);
    }

    @Override
    public void addFormId(String memberId, String[] formIds) {
//        ListOperations<String, String> stringStringListOperations = stringRedisTemplate.opsForList();
//        String key = formKeyPrefix + memberId;
//        Long size = stringStringListOperations.size(key);
//        if (size == null || size < 30) {
//            stringStringListOperations.rightPushAll(key, formIds);
//            if (size == null || size == 0) {
//                stringRedisTemplate.expire(key, 86400, TimeUnit.SECONDS);
//            }
//        }
        BoundListOperations<String, String> boundListOperations = stringRedisTemplate.boundListOps(formKeyPrefix + memberId);
        //队列左进右出
        boundListOperations.leftPushAll(formIds);
        //LTRIM命令从左到右保留5个， 就是最新的5个
        boundListOperations.trim(0, 4);
        //每次保存刷新过期时间+12小时， 最坏情况5*12=60小时之前的还没有被淘汰掉<7天有效期
        boundListOperations.expire(12, TimeUnit.HOURS);
    }

    @Override
    public String getFormId(String memberId) {
        ListOperations<String, String> stringStringListOperations = stringRedisTemplate.opsForList();
        //左进又出
        return stringStringListOperations.rightPop(formKeyPrefix + memberId);
    }

    private static char[] hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String md5(String s) {
        return s == null ? null : md5(s.getBytes());
    }

    public static String md5(byte[] data) {
        if (data == null) {
            return null;
        } else {
            try {
                MessageDigest mdTemp = MessageDigest.getInstance("MD5");
                mdTemp.update(data);
                byte[] md = mdTemp.digest();
                int j = md.length;
                char[] str = new char[j * 2];
                int k = 0;

                for(int i = 0; i < j; ++i) {
                    byte b = md[i];
                    str[k++] = hexDigits[b >> 4 & 15];
                    str[k++] = hexDigits[b & 15];
                }

                return new String(str);
            } catch (Exception var8) {
                return null;
            }
        }
    }

}
