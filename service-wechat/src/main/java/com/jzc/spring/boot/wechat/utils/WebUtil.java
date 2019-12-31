package com.jzc.spring.boot.wechat.utils;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

@Slf4j
public class WebUtil {

    public static <T> T getResult(HttpResponse httpResponse, Class<T> tClass) throws IOException {
        return JSON.parseObject(getResult(httpResponse), tClass);
    }

    public static String getResult(HttpResponse httpResponse) throws IOException {
        if (httpResponse == null || httpResponse.getStatusLine() == null) {
            log.error("httpResponse is null");
            throw new RuntimeException("httpResponse is null");
        }
        if (httpResponse.getStatusLine().getStatusCode() != 200) {
            log.error("statusCode is not 200 statusCode {} reasonPhrase {} ",
                    httpResponse.getStatusLine().getStatusCode(),
                    httpResponse.getStatusLine().getReasonPhrase());
            throw new RuntimeException("httpResponse is null");
        }

        String result = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
        log.info("result {} ", JSON.toJSONString(result));

        return result;
    }

}
