package com.jzc.spring.boot.test;

import org.junit.Test;

import java.util.regex.Pattern;

public class PatternTest {

    @Test
    public void patternTest() {

        String value = "1000";

        System.out.println(Pattern.matches("[0-9]{1,3}", value));

    }

}
