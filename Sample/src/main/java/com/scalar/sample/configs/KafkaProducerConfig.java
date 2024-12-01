package com.scalar.sample.configs;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.kafka.core.KafkaTemplate;

@Configurable
public class KafkaProducerConfig {
    private  final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducerConfig(KafkaTemplate<String, String> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publicEven(String topic, String message){
        kafkaTemplate.send(topic, message);
    }

}
