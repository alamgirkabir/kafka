/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kabir.kafka.service;

import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author lenovo
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class TopicProducer {

    @Value("${topic.name}")
    private String topicName;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendPriorityMessage(String message) {
        log.info("Payload enviado: {}", message);
        String key = UUID.randomUUID().toString();
        kafkaTemplate.send(topicName, 0, key, message);
    }

    public void send(String message) {
        log.info("Payload enviado: {}", message);
        String key = UUID.randomUUID().toString();
        kafkaTemplate.send(topicName, 1, key, message);
    }
}
