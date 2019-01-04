package com.jzc.spring.boot.test;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class JsonMain {

    @Value("classpath:json/data.json")
    private Resource areaRes;

    @Test
    public void run() {
        try {
            File file = areaRes.getFile();
            String jsonData = this.jsonRead(file);
            JSONObject jsonObject = JSONObject.parseObject(jsonData);

            System.out.println(jsonObject);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String jsonRead(File file){
        Scanner scanner = null;
        StringBuilder buffer = new StringBuilder();
        try {
            scanner = new Scanner(file, "utf-8");
            while (scanner.hasNextLine()) {
                buffer.append(scanner.nextLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        return buffer.toString();
    }

}
