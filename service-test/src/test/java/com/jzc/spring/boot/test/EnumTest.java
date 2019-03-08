package com.jzc.spring.boot.test;

import java.util.HashMap;
import java.util.Map;

public class EnumTest {

    public enum PayDictKeyEnum {

        ALIPAY_PID,//合作伙伴身份ID
        PRIVATE_KEY,//支付宝商户私钥
        PUBLIC_KEY,//支付宝商户公钥
        ALIPAY_PUBLIC_KEY,//支付宝公钥
        SIGN_TYPE;//支付宝 加密方式

    }
    static Map<String, String> map;
    static {
        map = new HashMap<String, String>(){{
            put("sign_type", "RSA2");
        }};
    }


    public static void main(String[] args) {

        System.out.println( PayDictKeyEnum.SIGN_TYPE.name() );

        System.out.println(map.get("sign_type"));
        System.out.println(map.get(PayDictKeyEnum.SIGN_TYPE.name()) );

    }

}
