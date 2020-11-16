package com.jzc.spring.boot.test;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.TopicPartition;
import org.junit.Test;

import java.util.Properties;

@Slf4j
public class KafkaProviderConsumer {

    private static KafkaConsumer<String, String> kafkaConsumer;

    private static Producer<String, String> producer;

    static {
        Properties consumerProperties = new Properties();
        consumerProperties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "10.100.50.51:9092");
        consumerProperties.put(ConsumerConfig.GROUP_ID_CONFIG, "j_test");
        consumerProperties.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 100);
        consumerProperties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        consumerProperties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        consumerProperties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);

        kafkaConsumer = new KafkaConsumer<>(consumerProperties);
        TopicPartition topicPartition = new TopicPartition("order_v2", 0);
        kafkaConsumer.assign(Lists.newArrayList(topicPartition));
        kafkaConsumer.seek(topicPartition, 19163);


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

    @Test
    public void startListener() {
        while (true) {
            waitTime();
            ConsumerRecords<String, String> records = kafkaConsumer.poll(100);
            for (ConsumerRecord<String, String> record : records) {
                log.info("kafka message key {}", record.key());
                log.info("kafka message value {}", record.value());
                log.info("kafka message topic {}", record.topic());

                sendMessage(record.value());
            }
        }
    }

    public void sendMessage(String message) {
        ProducerRecord<String, String> record = new ProducerRecord<>("order_v2", String.valueOf(System.currentTimeMillis()), message);
        try {
            producer.send(record).get();
        } catch (Exception e) {
            log.error("send kafka exception", e);
        }
    }


    private void waitTime() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
