/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kabir.kafka.service;

import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

/**
 *
 * @author lenovo
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class TopicListener {

    @Value("${topic.name}")
    private String topicName;

    @KafkaListener(topicPartitions = {
        @TopicPartition(topic = "kafka_test_1", partitions = {"1", "2", "3", "4", "5"})})
    public void consume(ConsumerRecord<String, String> payload, @Header(KafkaHeaders.RECEIVED_PARTITION) int partition) {
        log.info("Tópic: {}", topicName);
        log.info("Partition: {}", partition);
        log.info("key: {}", payload.key());
        log.info("Headers: {}", payload.headers());
        log.info("Partion: {}", payload.partition());
        log.info("Order: {}", payload.value());
        try {
            if (partition != 0) {
                Thread.sleep(10000);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(TopicListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @KafkaListener(topicPartitions = {
        @TopicPartition(topic = "kafka_test_1", partitions = {"0"})})
    public void priorityConsume(ConsumerRecord<String, String> payload, @Header(KafkaHeaders.RECEIVED_PARTITION) int partition) {
        log.info("Tópic: {}", topicName);
        log.info("Partition: {}", partition);
        log.info("key: {}", payload.key());
        log.info("Headers: {}", payload.headers());
        log.info("Partion: {}", payload.partition());
        log.info("Order: {}", payload.value());
    }

}
