package com.jzc.spring.boot.test.sync;

import java.util.HashMap;
import java.util.Map;

public class SyncProcessor {

    private Map<String, Long> map = new HashMap<String, Long>(){{
        put("a", 10L);
        put("b", 11L);
    }};

    public void testMethod() {
        Long a = map.get("a");
        synchronized (a) {
            System.out.println(a++);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
