package com.jzc.spring.es.high.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.jzc.spring.es.high.configuration.ClientInitialize;
import com.jzc.spring.es.high.data.ShopData;
import com.jzc.spring.es.high.entity.GoodsPriceResultDTO;
import com.jzc.spring.es.high.entity.MallProductESEntity;
import com.jzc.spring.es.high.service.ESProductTestService;
import org.apache.commons.lang3.RandomUtils;
import org.elasticsearch.action.DocWriteRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class ESProductTestServiceImpl implements ESProductTestService {

    private String index_0 = "product_test_0";

    public void insertProduct(MallProductESEntity entity) {
        long l = System.currentTimeMillis();
        int i = RandomUtils.nextInt(1, 9999);

        entity.setChannelGoodsId(UUID.randomUUID().toString());
        entity.setSkuId(String.valueOf(l) + String.valueOf(i));
        entity.setSkuName(entity.getSkuName() + entity.getSkuId());
        entity.setStandardPrice(new BigDecimal(RandomUtils.nextInt(1, 999999)));
        entity.setBarcode(entity.getSkuId());
        entity.setTpSku(entity.getSkuId() + "01");
        entity.setTitle(entity.getSkuName());
        entity.setGoodsPrices(new ArrayList<>());

        GoodsPriceResultDTO goodsPrice0 = new GoodsPriceResultDTO();
        goodsPrice0.setChannelGoodsId(entity.getChannelGoodsId());
        goodsPrice0.setPriceType(0);
        goodsPrice0.setAmount(new BigDecimal(i));
        goodsPrice0.setPriceCategory(1);
        entity.getGoodsPrices().add(goodsPrice0);
        entity.setGoodsPrices0(goodsPrice0.getAmount());

        GoodsPriceResultDTO goodsPrice1 = new GoodsPriceResultDTO();
        goodsPrice1.setChannelGoodsId(entity.getChannelGoodsId());
        goodsPrice1.setPriceType(1);
        goodsPrice1.setAmount(new BigDecimal(RandomUtils.nextInt(1, 999999)));
        goodsPrice1.setPriceCategory(1);
        entity.getGoodsPrices().add(goodsPrice1);
        entity.setGoodsPrices1(goodsPrice1.getAmount());

        GoodsPriceResultDTO goodsPrice2 = new GoodsPriceResultDTO();
        goodsPrice2.setChannelGoodsId(entity.getChannelGoodsId());
        goodsPrice2.setPriceType(2);
        goodsPrice2.setAmount(new BigDecimal(RandomUtils.nextInt(1, 999999)));
        goodsPrice2.setPriceCategory(1);
        entity.getGoodsPrices().add(goodsPrice2);
        entity.setGoodsPrices2(goodsPrice2.getAmount());

        Map<String, Object> dynamicDataMap = new HashMap<>();
        for (String shopId : ShopData.shopList) {
            String key = "dynamic_" + shopId + "_";
            dynamicDataMap.put(key + "dealCount", RandomUtils.nextInt(1, 999));
            dynamicDataMap.put(key + "channelGoodsStatus", RandomUtils.nextInt(0, 2));
        }

        Map<String, Object> parmas = JSONObject.parseObject(JSONObject.toJSONString(entity), new TypeReference<Map<String, Object>>(){});
        parmas.putAll(dynamicDataMap);

        BulkRequest request = new BulkRequest();
        String json = JSONObject.toJSONString(parmas);
        request.add(new IndexRequest(index_0).id(entity.getChannelGoodsId()).source(json, XContentType.JSON).opType(DocWriteRequest.OpType.INDEX));
        try {
            System.out.println(json);
            BulkResponse bulkResponse = ClientInitialize.getClient().bulk(request, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
