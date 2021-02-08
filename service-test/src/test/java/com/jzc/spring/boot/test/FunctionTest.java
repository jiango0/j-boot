package com.jzc.spring.boot.test;

import org.junit.Test;

import java.util.function.Function;

public class FunctionTest {

    @Test
    public void test() {

        Function<Integer, Integer> function = this::add;
//        Integer i = function.apply(3);
//        System.out.println(i);

        Function<Integer, Integer> function2 = k -> {
            System.out.println("自增2");
            return k + 2;
        };
        Function<Integer, Integer> compose = function.compose(function2);
        Integer k = compose.apply(6);
        System.out.println(k);
    }

    public int add(int i) {
        i++;
        System.out.println("自增1");
        return i;
    }

}
