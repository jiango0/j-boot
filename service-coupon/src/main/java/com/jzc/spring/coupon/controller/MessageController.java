package com.jzc.spring.coupon.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.jzc.spring.coupon.dao.message.MessageMapper;
import com.jzc.spring.coupon.model.Message;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("message")
public class MessageController {

    Map<String, AtomicInteger> countMap = new HashMap<>();

    @Autowired
    MessageMapper messageMapper;


    @RequestMapping(value = "save")
    public void save(@RequestBody Message message) {
        insert(message);


    }

    @RequestMapping(value = "save/all")
    public void saveAll() {
        Message message = new Message();
        message.setTitle(String.valueOf(System.currentTimeMillis()));
        message.setContent(String.valueOf(System.currentTimeMillis()));
        insert(message);

        AtomicInteger atomicInteger = countMap.get(message.getReceiver());
        if (atomicInteger == null) {
            atomicInteger = new AtomicInteger();
            countMap.put(message.getReceiver(), atomicInteger);
        }
        atomicInteger.getAndAdd(1);
    }

    @RequestMapping(value = "query/all")
    public String queryAll() {
        return JSONUtils.toJSONString(countMap);
    }

    private void insert(Message message) {
        Date now = new Date();
        message.setMerchantId("dwj");
        message.setMessageId(UUID.randomUUID().toString());
        message.setMessageStatus(0);
        message.setCreateAt(now);
        message.setChangeAt(now);
        int i = RandomUtils.nextInt(1, 4);

        message.setReceiver("" + i);
        message.setReceiverName("接受者J" + i);

        messageMapper.insert(message);
    }

}
