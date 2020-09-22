package com.jzc.spring.boot.test;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class KafkaSend {

    private static Producer<String, String> producer;

    static {
        Properties props = new Properties();
        props.put("bootstrap.servers", "10.100.50.51:9092");//服务器ip:端口号，集群用逗号分隔
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("producer.type", "sync");
        producer = new KafkaProducer<>(props);
    }

    public static void main(String[] args) {
        String topic = "payment_v2";
        String message = "{\"topic\":\"payment_v2\",\"bizType\":\"payment_v2\",\"bizItem\":\"charges\",\"message\":{\"paymentChagesId\":\"e760a8b7-ec69-4b3c-b9bf-0db5a6068b01\",\"txId\":\"6824814496335501407\",\"merchantId\":\"dwj\",\"shopId\":\"185f00b7-444c-48ac-b5df-2d9a956d5ba1\",\"orderChannel\":3,\"accountId\":\"2f4ec83e-4645-4ccf-93ab-63e1682345e5\",\"outTradeNo\":\"2009011202005092005578008909\",\"orderCode\":\"6824814492040599647\",\"userId\":\"622252******9603\",\"payProvider\":2,\"payChannel\":9,\"payType\":3,\"subPayType\":3,\"subject\":\"260元350币\",\"payStatus\":1,\"amount\":250,\"createdAt\":\"2020-05-09 20:05:52\",\"updatedAt\":\"2020-05-09 20:06:42\",\"billTime\":\"2020-05-09 20:06:42\",\"checkStatus\":0}}";

        ProducerRecord<String, String> record = new ProducerRecord<>(topic, String.valueOf(System.currentTimeMillis()), message);
        try {
            producer.send(record).get();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
