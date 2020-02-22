package com.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * @ license : (C) Copyright 2013-2019, SanGuo Information Technology Co., Ltd.
 * @ Author  : TimWang
 * @ FileName: KafkaProducerMsg.java
 * @ Time    : 2020/2/22 18:10
 * @ Software: IntelliJ IDEA
 */
public class KafkaProducerMsg {
    public static void main(String[] args) {
        Properties properties = new Properties();

        //指定kafka配置
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"192.168.1.7:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        //创建生产者
        Producer producer = new KafkaProducer(properties);
        producer.send(new ProducerRecord("test","message11111"));
        producer.close();
    }
}
