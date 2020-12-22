package com.jzc.spring.boot.test;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class SubList {

    static List<String> list = new ArrayList<String>(){{
        add("1");
        add("2");
        add("3");
        add("4");
        add("5");
    }};

    public static void main(String[] args) {
        List<String> strings = list.subList(1, 3);

        System.out.println(JSON.toJSON(strings));
    }



}
