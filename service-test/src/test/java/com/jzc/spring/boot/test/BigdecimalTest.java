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

    @Test
    public void rounding() {

        BigDecimal amount = new BigDecimal("8.119304347826087");

        System.out.println(amount.setScale(2, BigDecimal.ROUND_DOWN));

    }

    @Test
    public void bigdecimalsc() {
        BigDecimal amount = new BigDecimal("12.1234");

        System.out.println(amount.setScale(2, BigDecimal.ROUND_DOWN));

        System.out.println(amount);
    }

    @Test
    public void bigdecimalyy() {
        BigDecimal amount = BigDecimal.ONE;
        setBigdecimal(amount);
        amount = amount.add(BigDecimal.ONE);

        System.out.println(amount);
        System.out.println(xx);
    }

    BigDecimal xx = BigDecimal.ZERO;
    public void setBigdecimal(BigDecimal amount) {
        xx = amount;
    }

    @Test
    public void bigdecimalScale() {
        BigDecimal bigDecimal = new BigDecimal("11.22");

        System.out.println(bigDecimal.setScale(4, BigDecimal.ROUND_UP));

    }


}
