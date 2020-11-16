package com.jzc.spring.boot.test;


import com.jzc.spring.boot.test.model.GoodsPrice;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ReduceTest {

    List<GoodsPrice> list = new ArrayList<GoodsPrice>(){{
        GoodsPrice goodsPrice = new GoodsPrice();
        goodsPrice.setPriceType(1);
        goodsPrice.setPriceCategory("1");
        goodsPrice.setAmount(BigDecimal.ONE);
        add(goodsPrice);

        GoodsPrice goodsPrice2 = new GoodsPrice();
        goodsPrice2.setPriceType(1);
        goodsPrice2.setPriceCategory("1");
        goodsPrice2.setAmount(BigDecimal.TEN);
        add(goodsPrice);

        GoodsPrice goodsPrice3 = new GoodsPrice();
        goodsPrice3.setPriceType(2);
        goodsPrice3.setPriceCategory("1");
        goodsPrice3.setAmount(BigDecimal.TEN);
        add(goodsPrice);

    }};

    @Test
    public void reduceTest() {
        List<GoodsPrice> newList = new ArrayList<>();
        list.stream().reduce((acc, item) -> {

            return item;
        });


    }



}
