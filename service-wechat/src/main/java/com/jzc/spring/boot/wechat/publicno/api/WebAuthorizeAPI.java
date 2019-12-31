package com.jzc.spring.boot.wechat.publicno.api;

import com.jzc.spring.boot.wechat.publicno.result.AccessTokenResult;
import com.jzc.spring.boot.wechat.publicno.result.UserInfoResult;
import com.jzc.spring.boot.wechat.utils.WebUtil;
import org.apache.http.client.fluent.Request;

public class WebAuthorizeAPI {

    private static String OAUTH2_AUTHORIZE = "https://open.weixin.qq.com/connect/oauth2/authorize";

    private static String OAUTH2_ACCESS_TOKEN = "https://api.weixin.qq.com/sns/oauth2/access_token";

    private static String OAUTH2_REFRESH_TOKEN = "https://api.weixin.qq.com/sns/oauth2/refresh_token";

    private static String USERINFO = "https://api.weixin.qq.com/sns/userinfo";

    private static String secret = "6865dd9f64fa6fab01468ded0ba8b46a";

    /**
     * 用户授权
     *
     * @param appId
     * @param redirect_uri
     * @param baseInfo
     * @param state
     * @return
     */
    public static String getAuthorize(String appId, String redirect_uri, boolean baseInfo, String state) {
        StringBuffer url = new StringBuffer(OAUTH2_AUTHORIZE);

        url.append("?appid=").append(appId);
        url.append("&redirect_uri=").append(redirect_uri);
        url.append("&response_type=code");
        url.append("&scope=");
        if (baseInfo) {
            url.append("snsapi_base");
        } else {
            url.append("snsapi_userinfo ");
        }
        url.append("&state=").append(state);
        url.append("#wechat_redirect");

        return url.toString();
    }

    public static AccessTokenResult getAccessToken(String appid, String code) throws Exception {
        StringBuffer url = new StringBuffer(OAUTH2_ACCESS_TOKEN);

        url.append("?appid=").append(appid);
        url.append("&secret=").append(secret);
        url.append("&code=").append(code);
        url.append("&grant_type=authorization_code");

        return WebUtil.getResult(Request.Get(url.toString()).execute().returnResponse(), AccessTokenResult.class);
    }

    public static AccessTokenResult refreshToken() {
        return null;
    }

    public static UserInfoResult userinfo(String access_token, String openid, String lang) throws Exception {
        StringBuffer url = new StringBuffer(USERINFO);

        url.append("?access_token=").append(access_token);
        url.append("&openid=").append(openid);
        url.append("&lang=").append(lang);

        return WebUtil.getResult(Request.Get(url.toString()).execute().returnResponse(), UserInfoResult.class);
    }


}
