package com.jzc.spring.es.high;

import org.json.JSONArray;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public class A {

    public static String getData() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("channelGoodsId", UUID.randomUUID().toString());
        jsonObject.put("skuId", getSeq(4));
        jsonObject.put("skuName", "qweqwe");
        jsonObject.put("standardPrice", new BigDecimal(getSeq(6)));
        jsonObject.put("barcode", jsonObject.get("skuId"));
        jsonObject.put("tpSku", jsonObject.get("skuId") + "01");
        jsonObject.put("title", jsonObject.get("skuId") + "title");


        return jsonObject.toString();
    }

    private static String getSeq(int i) {
        String seq = "";
        Random random = new Random();
        for (int k=0; k<i; k++) {
            seq += random.nextInt(9);
        }

        return seq;
    }

    public String getData2() {
        Map map = new HashMap();
        map.put("a", "2");
        JSONObject jsonObject = new JSONObject(map);
        return jsonObject.toString();
    }

}
