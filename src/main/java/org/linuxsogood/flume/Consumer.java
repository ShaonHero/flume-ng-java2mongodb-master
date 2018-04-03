package org.linuxsogood.flume;

/**
 * INFO: info
 * User: zhaokai
 * Date: 2017/3/17
 * Version: 1.0
 * History: <p>如果有修改过程，请记录</P>
 */

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class Consumer {

    public static void main(String[] args) {
        System.out.println("begin consumer");
        connectionKafka();
        System.out.println("finish consumer");
    }

    @SuppressWarnings("resource")
    public static void connectionKafka() {

        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.174.101:9092");
        props.put("group.id", "testConsumer");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("session.timeout.ms", "30000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList("test0"));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (ConsumerRecord<String, String> record : records) {
                System.out.printf("===================offset = %d, key = %s, value = %s", record.offset(), record.key(),
                        record.value());
            }
        }
    }
}