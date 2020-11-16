package com.jzc.spring.boot.test;

import org.junit.Test;

public class StringFormatTest {

    private String msg = "%s只可购买%d个，已购%d个!";

    @Test
    public void msgFormat() {

        String m = String.format(msg, "每天", 2, 1);

        System.out.println(m);

    }

    @Test
    public void toBinary() {
        int num = 7;

        String binaryString = String.format("%08d", Integer.valueOf(Integer.toBinaryString(num)));
        char[] binaryChars = binaryString.toCharArray();
        for (int i = 0; i < binaryChars.length; i++) {
            if (binaryChars[i] == '1') {
                System.out.println((int) Math.pow(2, binaryChars.length - 1 - i));
            }
        }
    }


}
