package com.jzc.spring.boot.wechat.applets.controller;

import com.jzc.spring.boot.wechat.applets.api.WXAppletUserInfoAPI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("applets")
public class AppletsController {

    @RequestMapping(value = "/")
    public String msg(HttpServletRequest request) {

        String code = request.getParameter("code");
        String encryptedData = request.getParameter("encryptedData");
        String iv = request.getParameter("iv");

        log.info("code {} ", code);
        log.info("encryptedData {} ", encryptedData);
        log.info("iv {} ", iv);

        try {
            String session = WXAppletUserInfoAPI.code2sessionKey("wx8e42d53ad532956b", "3a79e47baa5094255e452b1521032e14", code);
            log.info(session);
        } catch (Exception e) {
            log.error("失败", e);
        }

        return "fail";
    }

}
