package com.jzc.spring.boot.wechat.publicno.result;

import lombok.Data;

@Data
public class UserInfoResult {

    private String openid;

    private String nickname;

    private String sex;

    private String province;

    private String city;

    private String country;

    private String headimgurl;

    private String privilege;

    private String unionid;

}
