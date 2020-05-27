package com.jzc.spring.boot.test;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigdecimalTest {

    @Test
    public void boundUp() {

        BigDecimal bigdecimal = new BigDecimal(0.88);

        System.out.println(bigdecimal);
        System.out.println(bigdecimal.movePointRight(1).setScale(1, BigDecimal.ROUND_DOWN));

    }

    @Test
    public void RoundingModeUP () {

        BigDecimal amount = new BigDecimal("79.8");
        BigDecimal result = amount.divide(BigDecimal.valueOf(103), 8, RoundingMode.UP);

        System.out.println(result);
    }

    @Test
    public void bdx() {
        BigDecimal d = new BigDecimal("1");
        BigDecimal x = new BigDecimal("2");

        System.out.println(d.compareTo(x));
    }

}
