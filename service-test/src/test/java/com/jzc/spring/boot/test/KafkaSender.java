package com.jzc.spring.boot.test;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.Test;

import java.util.Properties;

@Slf4j
public class KafkaSender {

    private static Producer<String, String> producer;

    static {
        Properties props = new Properties();
        props.put("bootstrap.servers", "10.100.51.56:9092");//服务器ip:端口号，集群用逗号分隔
        props.put("acks", "all");
        props.put("retries", "0");
        props.put("batch.size", "16384");
        props.put("linger.ms", "1");
        props.put("buffer.memory", "33554432");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("producer.type", "sync");
        producer = new KafkaProducer<>(props);
    }

    public static void send (String topic, String message) {
        ProducerRecord<String, String> record = new ProducerRecord<>(topic, String.valueOf(System.currentTimeMillis()), message);
        try {
            producer.send(record).get();
        } catch (Exception e) {
            log.error("send kafka exception", e);
        }
    }

    @Test
    public void start() {
        String topic = "order_v2";
        String message = "{\"topic\":\"order_v2\",\"bizType\":\"order_v2\",\"bizItem\":\"order_v2_normal\",\"message\":{\"orderCode\":\"68755193125688815442\",\"shopId\":\"11885493-d1b2-48d4-a43c-8142c005e5b1\",\"merchantId\":\"dwj\",\"orderChannel\":3,\"orderType\":3,\"orderDirection\":0,\"orderName\":\"游戏币\",\"orderStatus\":2,\"shippedStatus\":1,\"payStatus\":1,\"shippedType\":0,\"goodsNum\":1,\"remark\":\"现金付款\",\"creator\":\"胡一一\",\"orderAt\":\"2020-09-23 11:26:27\",\"updatedAt\":\"2020-09-23 11:26:28\",\"finishedAt\":\"2020-09-23 11:26:28\",\"payedAt\":\"2020-09-23 11:26:27\",\"shippedAt\":\"2020-09-23 11:26:28\",\"orderDetailList\":[{\"orderDetailId\":\"568b9001-d624-11ea-8061-000c2929f0b1\",\"goodsSku\":\"BI20190001\",\"goodsType\":0,\"goodsCategory\":\"01-0101\",\"goodsName\":\"游戏币\",\"goodsQty\":1,\"orderItemDetailList\":[{\"goodsPrice\":1,\"priceType\":0,\"amountTotal\":1,\"amountDiscount\":0,\"amountPayable\":1,\"amountShare\":1}]}],\"orderShipping\":{\"shippingType\":\"normal_goods\"},\"orderBuyer\":{\"memberType\":\"2\"},\"orderPayment\":{\"amount\":100,\"payChannel\":8,\"payType\":4},\"orderPaySummaryList\":[{\"priceType\":0,\"amountDiscount\":0,\"amountPayable\":1,\"amountTotal\":1}],\"orderExt\":{\"cashier_code\":\"c44b04b4-2c00-493d-95ea-ea3f419a76ac\",\"sourceProduct\":0,\"bizCode\":\"1112110\",\"shopName\":\"上海闵行区上海浦江万达\",\"give_amount\":0,\"device_num\":\"ece0d954-48db-47db-bb51-9e6c6b2d0f57\",\"cashier_name\":\"胡一一\",\"sale_quantity\":1,\"order_category\":0,\"device_name\":\"收银台郑玲聪0925\",\"brandId\":\"c2e802ba-0c6b-2460-8ec4-9cb810c92b6c\",\"busType\":\"CASH_CURRENCY\",\"goodsName\":\"游戏币\",\"give_quantity\":0}}}";

        send(topic, message);
    }

}
