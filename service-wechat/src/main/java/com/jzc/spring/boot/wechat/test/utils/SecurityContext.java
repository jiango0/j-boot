package com.jzc.spring.boot.wechat.test.utils;

import lombok.Data;

@Data
public class SecurityContext {

    private String sessionKey;

    private String openId;

    private String unionId;

    private String memberId;

    private String nickName;

    private String partnerSign;

    private String merchantId;

}
