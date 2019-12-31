package com.jzc.spring.boot.wechat.test.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class UserInfoDTO {

    @JsonIgnore
    private String sessionKey;
    @JsonIgnore
    private String openId;
    @JsonIgnore
    private String unionId;
    @JsonIgnore
    private String memberId;
    @JsonIgnore
    private String partnerSign;

    private String merchantId;

    private String nickName;

    private boolean login;

    private String token;

}
