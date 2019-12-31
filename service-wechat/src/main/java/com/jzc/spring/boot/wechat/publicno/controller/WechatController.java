package com.jzc.spring.boot.wechat.publicno.controller;

import com.alibaba.fastjson.JSON;
import com.jzc.spring.boot.wechat.publicno.api.WebAuthorizeAPI;
import com.jzc.spring.boot.wechat.publicno.result.AccessTokenResult;
import com.jzc.spring.boot.wechat.publicno.result.UserInfoResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("wechat")
public class WechatController {

    @RequestMapping(value = "/")
    public String msg(HttpServletRequest request) {

        String code = request.getParameter("code");
        String state = request.getParameter("state");

        log.info("code {} ", code);
        log.info("state {} ", state);

        try {
            AccessTokenResult accessToken = WebAuthorizeAPI.getAccessToken("wx2762ee7b2f48b6e7", code);
            String accessTokenStr = JSON.toJSONString(accessToken);
            log.info("AccessTokenResult {} ", accessTokenStr);

            if ("wx".equalsIgnoreCase(state) && accessToken != null) {
                UserInfoResult userInfoResult = WebAuthorizeAPI.userinfo(accessToken.getAccess_token(), accessToken.getOpenid(), "zh_CN");
                String userInfoResultStr = JSON.toJSONString(userInfoResult);
                log.info("UserInfoResult {} ", userInfoResultStr);
                return userInfoResultStr;
            }

            return accessTokenStr;
        } catch (Exception e) {
            log.error("失败", e);
        }

        return "fail";
    }

}
