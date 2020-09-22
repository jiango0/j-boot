package com.jzc.spring.boot.test;

import org.junit.Test;

public class SplitTest {

    @Test
    public void split() {

        String key = "123,456";
        String[] split = key.split(",");

        System.out.println(split.length);
        System.out.println(split[0]);

        System.out.println(split[0] + "\t" + split[1]);
    }

}
