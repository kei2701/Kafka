package com.kafka.KafkaProducer.service.impl;

import com.kafka.KafkaProducer.service.IKafkaProducerServices;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Service
public class KafkaProducerServicesImpl implements IKafkaProducerServices {
    private final RestTemplate restTemplate;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducerServicesImpl(RestTemplate restTemplate, KafkaTemplate<String, String> kafkaTemplate) {
        this.restTemplate = restTemplate;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void fetchAndSendPostData() {
        int randomId = new Random().nextInt(100) + 1;
        String url = "https://jsonplaceholder.typicode.com/posts/" + randomId;

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            kafkaTemplate.send("posts-topic", response.getBody());
        } else {
            throw new RuntimeException("Failed to fetch data");
        }

    }
}
