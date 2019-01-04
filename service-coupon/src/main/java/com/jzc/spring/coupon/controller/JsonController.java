package com.jzc.spring.coupon.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

@RestController
@RequestMapping("json")
public class JsonController {

    @Value("classpath:json/data")
    private Resource areaRes;

    @RequestMapping(value = "readJson")
    public void readJson() {
        try {
            File file = areaRes.getFile();
            String jsonData = this.jsonRead(file);

            JSONArray objects = JSONArray.parseArray(jsonData);

            System.out.println(objects);
            Set<String> set = new HashSet<>();
            for(int i=0; i<objects.size(); i++) {
                JSONObject o = (JSONObject) objects.get(i);
                JSONArray prodChannelShops = (JSONArray)o.get("prodChannelShops");
                if(prodChannelShops == null) {

                }
                JSONObject o1 = (JSONObject) prodChannelShops.get(0);

                if(set.add((String) o1.get("shop_id"))) {
                    System.out.println(o1.get("shop_id"));
                }
//                set.add((String) o1.get("shop_id"));
//                System.out.println(o1.get("shop_name") + "_" + o1.get("shop_id"));
            }

            System.out.println(set);
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
