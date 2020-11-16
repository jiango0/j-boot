package com.jzc.spring.boot.test.test;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.fluent.Request;
import org.junit.Test;

import java.io.IOException;

@Slf4j
public class DownloadTest {

    @Test
    public void download() throws IOException {
        int fail = 0;
//        for (String url : list) {
//            url = url.replace("toonyoo-static.oss-cn-beijing.aliyuncs.com", "oss.kiscloud.net");
//            HttpResponse httpResponse = Request.Get(url).execute().returnResponse();
//
//            StatusLine statusLine = httpResponse.getStatusLine();
//            int statusCode = statusLine.getStatusCode();
//            String reasonPhrase = statusLine.getReasonPhrase();
//
//            log.error("statusCode {} ", statusCode);
//            log.error("reasonPhrase {} ", reasonPhrase);
//
//            if (statusCode != 200) {
//                fail++;
//            }
//        }
//
//        log.info("fail {}", fail);
    }

}
