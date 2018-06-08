package com.jzc.spring.boot.test;

import org.junit.Test;

import java.util.UUID;

public class MainProcessorTest {

    @Test
    public void createGuid() {
        System.out.println(UUID.randomUUID().toString().toUpperCase());
    }

}
