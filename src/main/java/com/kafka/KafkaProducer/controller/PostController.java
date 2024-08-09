package com.kafka.KafkaProducer.controller;

import com.kafka.KafkaProducer.dto.response.GeneralResponse;
import com.kafka.KafkaProducer.service.IKafkaProducerServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final IKafkaProducerServices kafkaProducerServices;

    public PostController(IKafkaProducerServices kafkaProducerServices) {
        this.kafkaProducerServices = kafkaProducerServices;
    }

    @PostMapping
    public ResponseEntity<Object> fetchAndSendPost() {
        kafkaProducerServices.fetchAndSendPostData();
        return ResponseEntity.ok(
                GeneralResponse.builder()
                        .success(true)
                        .message("Send data successfully")
                        .data("Successful")
                        .build()
        );
    }
}
