/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kabir.kafka.service;

/**
 *
 * @author lenovo
 */
import java.util.function.Supplier;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
public class KafkaTopicConfiguration {

    @Value("${topic.name}")
    private String topicName;

    @Bean
    public NewTopic topicExample(KafkaAdmin admin) {
        admin.setBootstrapServersSupplier(() -> "http://ocr-dev.apurbatech.com:9092");
        return TopicBuilder.name(topicName)
                .partitions(6)
                .replicas(3)
                .build();
    }
}
