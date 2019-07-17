package com.jzc.spring.boot.test;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class RunnableTest {

    @Test
    public void runnable() {

        run("key", () -> {
            System.out.println("11111");

            if (1==1) {
                return;
            }

            System.out.println("22222");

            System.out.println("33333");

        });

    }


    private void run(String key, Runnable runnable) {
        System.out.println(key + "1");

        runnable.run();

        System.out.println(key + "2");
    }

    @Test
    public void ecode() throws Exception {

        String decode = URLDecoder.decode("%E9%93%B6%E8%81%94POS%E6%B6%88%E8%B4%B9", "UTF-8");
        String decode2 = new String(URLDecoder.decode("%E9%93%B6%E8%81%94POS%E6%B6%88%E8%B4%B9", "UTF-8").getBytes(), "UTF-8");

        System.out.println(decode);
        System.out.println(decode2);

        byte[] bytes = Base64.decodeBase64("COlsIhhFxlENxZoWniHXpO/8hWkPE/0KKgYkckY1Pw5gxTb1yhbtp6oS/zT0ZO1YU/2NJCfHyDgxmccD+UplHvytgvCuBSgfWSrbKKz3ViQzlLS7oQ6QygDqivf3vxF4xQGITdR/dYv2DV4kt0UnI3gGL1aBKd4RnBynhpfhzwE=");

        System.out.println(new String(bytes, "UTF-8"));

    }

}
