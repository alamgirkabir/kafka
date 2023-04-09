/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kabir.kafka.service;

/**
 *
 * @author lenovo
 */
import java.util.Objects;
import org.apache.kafka.clients.producer.internals.DefaultPartitioner;
import org.apache.kafka.common.Cluster;

/**
 * created by imteyaza-1lm on 2019-04-16
 *
 */
public class CustomPartitioner extends DefaultPartitioner {

    @Override
    public int partition(String topic, Object key, byte[] keyBytes,
            Object value, byte[] valueBytes,
            Cluster cluster) {

        String partitionKey = null;
        if (Objects.nonNull(key)) {
            String bookingKey = (String)key;
//            partitionKey = bookingKey.getCustomerId();
            //Ignore bookingKey.getBookingDate()
            keyBytes = bookingKey.getBytes();
        }
        return super.partition(topic, partitionKey, keyBytes, value,
                valueBytes, cluster);
    }
}
