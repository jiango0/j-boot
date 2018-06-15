package com.jzc.spring.boot.test;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.UUID;

public class MainProcessorTest {

    @Test
    public void createGuid() {
        System.out.println(UUID.randomUUID().toString().toUpperCase());
    }

    @Test
    public void hashTest() {
        System.out.println( "123".hashCode() );
        System.out.println( Integer.valueOf(123).hashCode() );
        System.out.println( Long.valueOf(123).hashCode() );
        System.out.println( Boolean.valueOf(true).hashCode() );
        System.out.println( BigDecimal.valueOf(123).hashCode() );
    }

}
