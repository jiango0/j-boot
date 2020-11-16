package com.jzc.spring.boot.test;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class HashCode {

    @Test
    public void hashco() {

        String str = "ec660ef3-d51a-43ca-b5aa-8545e8786a63";

        System.out.println(str.hashCode());

        int i = Math.abs(str.hashCode() % 20);

        i += 11;

        System.out.println(i);


        System.out.println(i);

    }

    @Test
    public void hashcodetest() {
        Map<Integer, Integer> hashCodeMap = new HashMap<>();
        for (int k=0; k<100; k++) {
            String uuid = UUID.randomUUID().toString();
            System.out.println(uuid.hashCode());

            int i = Math.abs(uuid.hashCode() % 20);

            i += 11;

            System.out.println(i);

            if (hashCodeMap.containsKey(i)) {
                hashCodeMap.put(i, hashCodeMap.get(i) + 1);
            } else {
                hashCodeMap.put(i, 1);
            }
        }

        System.out.println(JSONObject.toJSONString(hashCodeMap));
    }

}
