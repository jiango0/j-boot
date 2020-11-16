package com.jzc.spring.boot.test;


import java.util.Collections;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListSortTest {

    List<Map<String, Integer>> list = new ArrayList<Map<String, Integer>>(){{
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("i", 2);
        add(map1);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("i", 1);
        add(map2);

        Map<String, Integer> map3 = new HashMap<>();
        map3.put("i", 3);
        add(map3);

        Map<String, Integer> map4 = new HashMap<>();
        map4.put("i", 4);
        add(map4);
    }};

    @Test
    public void listSort() {

        Collections.sort(list, (o1, o2) -> {
            if (o1.get("i") > o2.get("i")) {
                return 1;
            } else {
                return 0;
            }
        });


        System.out.println(JSON.toJSONString(list));
    }

}
