package com.jzc.spring.boot.test;

import org.junit.Test;

import java.util.regex.Pattern;

public class PatternTest {

    @Test
    public void patternTest() {

        String value = "99999999.1234";

        Pattern quantityPattern = Pattern.compile("^(\\d{1,8}(\\.\\d{1,4})?)$");

        System.out.print(!quantityPattern.matcher(value).matches());

    }

}
