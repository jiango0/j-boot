package com.java.spring.boot.event;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import org.apache.http.util.EntityUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.junit.Test;
import weixin.popular.bean.wxa.WxaDUserInfo;
import weixin.popular.util.WxaUtil;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.AlgorithmParameters;
import java.security.Security;
import java.util.Arrays;

@Slf4j
public class WechatTests {


    @Test
    public void app() throws IOException {
        String code = "071XB39a0BQn4z1rwC5a0SP99a0XB393";
        String encryptedData = "Ey2Qsn85fj876nKa+jh0daqveFthLu5FWr0NZKtiPcrTKveIpB33Sf5UAfUJW61BmW0JtFNp+3ix+V2PCfySdouhnoBrrSexRq53an6jZz5kf6hzxVp2Krly1OIhltMyKAUl6g48SkpjCQpEtUoIZQN773VPI3pxDbttN4xYceX3qGo3ZIMOV+ro/t6EbK2GJEgLH0hyJBfhtHNSHHl+reKPveUG8bnneqLzaptCvEAT7uk6yNeMeUcIOYcHJoXvJkYrD9G8k+v3AappdGpVanN/w+xYTDxsOkBlSE1AXdgiKILV/5Stn88KgeBuKc8ikLMnK41A87oKDGUx0G7czR1IohMO2yfXhQ3OZqV6oxLBNJnBAKOMOiWZNPxUZzbJVWHwG2Ho1obcOcKCMzh/Fi5USBhj47bmUHvjr1oAYYOZi/VzeO8WyfVmWy3SbQ1gopAdU6fx8hMww69ZbF5yUN+N+lQkoN/vimZSRsVY9FzkdYPWe4h6JYLIEjtcYQMliL99qCSR/QnLk2dgug6w9AQrvmJXdChy6SSA9jNrFqk=";
        String iv = "BIbAgYB2x4iXCwyCOlGHvQ==";

        JSONObject jsonObject = code2sessionKey(code);

        String openId = jsonObject.getString("openid");// 用户唯一标识

        String session_key = jsonObject.getString("session_key");// 密钥


        JSONObject object = decryptionUserInfo(encryptedData, session_key, iv);
        WxaDUserInfo wxaDUserInfo = WxaUtil.decryptUserInfo(session_key, encryptedData, iv);


        log.info("object {}", JSON.toJSONString(object));
        log.info("wxaDUserInfo {}", JSON.toJSONString(wxaDUserInfo));
    }


    public JSONObject code2sessionKey(String code) throws IOException {
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=wx8e42d53ad532956b&secret=3a79e47baa5094255e452b1521032e14&js_code=" + code + "&grant_type=authorization_code";
        HttpResponse httpResponse = Request.Get(url).execute().returnResponse();

        if (httpResponse == null || httpResponse.getStatusLine() == null) {
            log.error("httpResponse is null");
        }
        if (httpResponse.getStatusLine().getStatusCode() != 200) {
            log.error("statusCode is not 200 statusCode {} reasonPhrase {} ",
                    httpResponse.getStatusLine().getStatusCode(),
                    httpResponse.getStatusLine().getReasonPhrase());
        }
        String result = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
        log.info("result {} ", JSON.toJSONString(result));

        return JSON.parseObject(result);
    }

    public static JSONObject decryptionUserInfo(String encryptedData, String sessionKey, String iv) {
        // 被加密的数据
        byte[] dataByte = Base64.decode(encryptedData);
        // 加密秘钥
        byte[] keyByte = Base64.decode(sessionKey);
        // 偏移量
        byte[] ivByte = Base64.decode(iv);

        try {
            // 如果密钥不足16位，那么就补足. 这个if 中的内容很重要
            int base = 16;
            if (keyByte.length % base != 0) {
                int groups = keyByte.length / base + (keyByte.length % base != 0 ? 1 : 0);
                byte[] temp = new byte[groups * base];
                Arrays.fill(temp, (byte) 0);
                System.arraycopy(keyByte, 0, temp, 0, keyByte.length);
                keyByte = temp;
            }
            // 初始化
            Security.addProvider(new BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding", "BC");
            SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");
            AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
            parameters.init(new IvParameterSpec(ivByte));
            cipher.init(Cipher.DECRYPT_MODE, spec, parameters);// 初始化
            byte[] resultByte = cipher.doFinal(dataByte);
            if (null != resultByte && resultByte.length > 0) {
                String result = new String(resultByte, "UTF-8");
                return JSONObject.parseObject(result);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Test
    public void maaa() throws UnsupportedEncodingException {
//        org.apache.commons.codec.binary.Base64.encodeBase64("4878dfd6-b8d8-44de-9a7a-6a83e570b89b".getBytes());
        System.out.println(new String(org.apache.commons.codec.binary.Base64.encodeBase64("4878dfd6-b8d8-44de-9a7a-6a83e570b89b".getBytes()), "utf-8"));
    }

}
