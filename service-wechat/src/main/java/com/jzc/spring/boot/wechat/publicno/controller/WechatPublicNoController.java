package com.jzc.spring.boot.wechat.publicno.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import weixin.popular.api.TokenAPI;
import weixin.popular.bean.token.Token;

@Slf4j
@RestController
@RequestMapping("wechat/public")
public class WechatPublicNoController {

    /**
     * 获取AccessToken（公众号需要增加白名单）
     *
     * @param appId
     * @param appSecret
     * @return
     */
    @RequestMapping(value = "getAccessToken")
    public Token getAccessToken(String appId, String appSecret) {
        return TokenAPI.token(appId, appSecret);
    }



}
