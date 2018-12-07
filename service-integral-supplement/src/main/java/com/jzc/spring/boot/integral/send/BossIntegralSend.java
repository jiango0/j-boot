package com.jzc.spring.boot.integral.send;

import com.alibaba.fastjson.JSON;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class BossIntegralSend {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendIntegral(Map<String, Object> map) {
        rabbitTemplate.convertAndSend("", "MEMBER_INTEGRAL_VARIATION", JSON.toJSONString(map));
    }

}
