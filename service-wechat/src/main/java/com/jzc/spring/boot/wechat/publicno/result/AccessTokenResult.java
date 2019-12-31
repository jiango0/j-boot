package com.jzc.spring.boot.wechat.publicno.result;

import lombok.Data;

@Data
public class AccessTokenResult {

    private String access_token;

    private Integer expires_in;

    private String refresh_token;

    private String openid;

    private String scope;

}
