package com.jzc.spring.boot.wechat;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import weixin.popular.api.WxaAPI;
import weixin.popular.bean.wxa.Getwxacodeunlimit;

import java.awt.image.BufferedImage;

@Slf4j
public class WeChatAppletCodeTest {

    @Test
    public void wechatCode() {
        String access_token = "28_eEYWiDQvx5HrTnG7wok93hVwRO0QyLxA3xb0TAuiXIE__bYaPVb7KZQP5gVGqbOfH5snA4kESFrJIyXbVhC7g5IHHuaW7JthlGiwcStr4gGoJGvgxZ8d_rbR-dn5OwzQpKjJ08OV1-QujJXYSOIjACAYUO";
        Getwxacodeunlimit getwxacodeunlimit = new Getwxacodeunlimit();
        getwxacodeunlimit.setScene("123");
        BufferedImage result = WxaAPI.getwxacodeunlimit(access_token, getwxacodeunlimit);
        result.getData();

        log.info("result {} ", JSON.toJSONString(result));

    }

}
