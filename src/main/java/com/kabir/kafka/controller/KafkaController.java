/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kabir.kafka.controller;

import com.kabir.kafka.service.TopicProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lenovo
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private final TopicProducer topicProducer;

    @GetMapping(value = "/send")
    public void send() {
        topicProducer.send("Mensagem de teste enviada ao tópico");
    }

    @GetMapping(value = "/send-priority")
    public void sendPriority() {
        topicProducer.sendPriorityMessage("Mensagem de teste enviada ao tópico");
    }
}
