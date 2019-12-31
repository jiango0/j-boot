package com.jzc.spring.boot.wechat.applets.api;

import com.jzc.spring.boot.wechat.utils.WebUtil;
import org.apache.http.client.fluent.Request;

public class WXAppletUserInfoAPI {

    private static String JSCODE2SESSION = "https://api.weixin.qq.com/sns/jscode2session";

    public static String code2sessionKey(String appid, String secret, String code) throws Exception {
        StringBuffer url = new StringBuffer(JSCODE2SESSION);
        url.append("?appid=").append(appid);
        url.append("&secret=").append(secret);
        url.append("&js_code=").append(code);
        url.append("&grant_type=authorization_code");
        return WebUtil.getResult(Request.Get(url.toString()).execute().returnResponse());
    }

}
