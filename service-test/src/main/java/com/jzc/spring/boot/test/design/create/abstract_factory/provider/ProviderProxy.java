package com.jzc.spring.boot.test.design.create.abstract_factory.provider;

import java.util.HashMap;
import java.util.Map;

public class ProviderProxy {

    static Map<String, Provider> map = new HashMap<String, Provider>(){{
        put("mail", new SendMailFactory());
        put("sms", new SendSmsFactory());
    }};

    public static Provider getProvider(String key) {
        return map.get(key);
    }

}
