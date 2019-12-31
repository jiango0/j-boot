package com.jzc.spring.boot.test;

import org.junit.Test;

import java.math.BigDecimal;

public class BigdecimalTest {

    @Test
    public void boundUp() {

        BigDecimal bigdecimal = new BigDecimal(0.88);

        System.out.println(bigdecimal);
        System.out.println(bigdecimal.movePointRight(1).setScale(1, BigDecimal.ROUND_DOWN));

    }

}
