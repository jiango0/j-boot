package com.jzc.spring.boot.event;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Slf4j
public class UrlTestMain {

    @Test
    public void url() {

        String url = "http://toonyoo-test.oss-cn-beijing.aliyuncs.com/image/other/other/20191128/20191128214405_368.jpg?x-oss-process=image/resize,m_fixed,h_900,w_900,limit_0,image/crop,x_0,y_0,w_450,h_450";

        url = url.substring(0, url.indexOf("?"));

        System.out.println(url);

    }

    @Test
    public void random() {

        Map<Integer, Integer> count = new HashMap<>();

        Integer fragmentQty = 4;

        Random random = new Random();

        for (int i=0; i<100; i++) {
            int count1 = random.nextInt(9);

//            System.out.println(random.nextInt(fragmentQty));
//            System.out.println(random.nextInt(fragmentQty)+1);

            if (!count.containsKey(count1)) {
                count.put(count1, 1);
            } else {
                count.put(count1, count.get(count1)+1);
            }

        }

        System.out.println(count);

    }

}
