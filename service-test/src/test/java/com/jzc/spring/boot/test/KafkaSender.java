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
        props.put("bootstrap.servers", "10.100.50.22:9092");//服务器ip:端口号，集群用逗号分隔
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
        String topic = "payment_v2";
        String message = "{\"topic\":\"payment_v2\",\"bizType\":\"payment_v2\",\"bizItem\":\"charges\",\"message\":{\"paymentChagesId\":\"a2b972b5-0a25-49c0-9749-0abe2a1c042f\",\"txId\":\"6843224530052297821\",\"merchantId\":\"dwj\",\"shopId\":\"345d34b4-4cd2-4976-a9af-82511a8ab639\",\"orderChannel\":3,\"orderCode\":\"6843223799907857501\",\"payChannel\":9,\"payType\":3,\"payProvider\":2,\"subject\":\"游戏币\",\"payStatus\":1,\"amount\":1,\"createdAt\":\"2020-06-28 11:04:22\",\"updatedAt\":\"2020-06-28 11:04:22\",\"billTime\":\"2020-06-28 11:04:22\"}}";

        send(topic, message);
    }

}
