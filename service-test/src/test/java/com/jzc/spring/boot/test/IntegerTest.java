package com.jzc.spring.boot.test;

import org.junit.Test;

public class IntegerTest {

    @Test
    public void cf() {
        int limit = 500;
        int count = 1501;
        int i = count % limit;
        int num = (count / limit);
        if (i != 0) {
            num++;
        }

        System.out.println(num);

    }

}
