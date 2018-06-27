package com.jzc.spring.boot.test;

import com.jzc.spring.boot.test.garble.IdGarble;
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

    @Test
    public void randomNum() {
        int randomDigit = 4;
        int length = 1;
        for(int i=1; i<randomDigit; i++) {
            length = length * 10;
        }
        System.out.println((int)((Math.random() * 9 + 1) * length));
    }

    @Test
    public void mathRandom() {
        System.out.println("123");
        System.out.println("123".toCharArray()[2]);
        System.out.println(Integer.valueOf(1) );
        System.out.println((int) ((Math.random() * 9 + 1) * 10)  );
    }

    @Test
    public void run() {
        IdGarble id = new IdGarble();
        System.out.println(id.alternately(id.generateRandom(4), "1" ) );
    }

}
