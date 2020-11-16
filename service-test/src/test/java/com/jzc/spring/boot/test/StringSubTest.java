package com.jzc.spring.boot.test;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

public class StringSubTest {

    @Test
    public void strSub() {
        String physicalNo = "735C7C11";

        if (StringUtils.isBlank(physicalNo) || physicalNo.length() % 2 != 0) {
            System.out.println(physicalNo);
        }

        StringBuilder stringBuilder = new StringBuilder();
        int length = physicalNo.length();
        for (int i = length / 2; i > 0; i--) {
            stringBuilder.append(physicalNo.substring(length - 2, length));
            length = length - 2;
        }

        System.out.println(stringBuilder.toString());
    }


}
