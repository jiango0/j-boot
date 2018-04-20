package com.java.spring.boot.event;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.jzc.spring.boot.Application;
import com.jzc.spring.boot.event.entity.Goods;
import com.jzc.spring.boot.event.service.GoodsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class GoodsApplicationTests {

    @Value(value = "classpath:data.json")
    private Resource resource;

    @Autowired
    private GoodsService goodsService;

    @Test
    public void batchGoods() {
        goodsService.batchGoods(this.getGoodsList());
    }

    @Test
    public void getTerm() {
        List<Goods> list = goodsService.getTerm("6.3英寸");
        System.out.println(JSON.toJSONString(list, SerializerFeature.PrettyFormat));
    }

    @Test
    public void getBool() {
        List<Goods> list = goodsService.getBoolQuery("小米", 100, "5.9英寸");
        System.out.println(JSON.toJSONString(list, SerializerFeature.PrettyFormat));
    }



    private List<Goods> getGoodsList() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream()));
            StringBuffer message = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                message.append(line);
            }

            return JSON.parseObject(message.toString(), new TypeReference<List<Goods>>() {});
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
