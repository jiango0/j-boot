package com.jzc.spring.coupon.constant;

import java.util.HashMap;
import java.util.Map;

public class PartnerMap {

    private static Map<String, String> map = new HashMap<String, String>(){{
        put("4483259F-3261-41F0-922F-E9EEC4166374", "Play1互动中心");
        put("142F0894-66B4-4A4C-AB0D-6A84B5891C08", "蜜柚潮玩");
        put("1ED99993-AF12-4DEB-9A5A-3B545AB4E54C", "大玩家超乐场");
        put("5AC8CE38-3020-4061-AE7F-CAF2829C6D62", "大玩家股份公司");
    }};

    public static String getPartnerName(String key) {
        return map.get(key);
    }

}
