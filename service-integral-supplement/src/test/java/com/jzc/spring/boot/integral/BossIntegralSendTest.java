package com.jzc.spring.boot.integral;

import com.jzc.spring.boot.integral.send.BossIntegralSend;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = IntegralApplication.class)
@WebAppConfiguration
public class BossIntegralSendTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    BossIntegralSend bossIntegralSend;

    @Test
    public void sendIntegral() {
        Map<String, Object> map = new HashMap<>();

        /**
         *
             {
             "amount": 100,
             "card_number": "NY00333333",
             "guid": "c5d72212-1112-4143-87b1-d3cad3a0a46a",
             "name": "会员购币",
             "partner_sign": "6A8CA59D-599A-4B2E-9252-2B72D502E4FF",
             "shop_guid": "245DA5D2-3FED-44D8-91F6-58E391E67EB5",
             "type": 0
             }
         * */

        map.put("amount", 1);
        map.put("card_number", "NY00008800");
        map.put("guid", UUID.randomUUID().toString());
        map.put("name", "套餐销售(会员)");
        map.put("partner_sign", "6A8CA59D-599A-4B2E-9252-2B72D502E4FF");
        map.put("shop_guid", "245DA5D2-3FED-44D8-91F6-58E391E67EB5");
        map.put("type", 0);

//        map.put("partner_sign", "6A8CA59D-599A-4B2E-9252-2B72D502E4FF");
//        map.put("amount", "1");
//        map.put("order_code", "2018091715542321");
//        map.put("type", "0");
//        map.put("card_number", "03990016171");
//        map.put("source", "系统增加积分");
//        map.put("shop_guid", "245DA5D2-3FED-44D8-91F6-58E391E67EB5");
//        map.put("guid", UUID.randomUUID().toString());

        bossIntegralSend.sendIntegral(map);
    }

}
