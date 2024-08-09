package com.kafka.KafkaProducer.dto.response;

import lombok.Data;

@Data
public class PostResponse {
    private int id;
    private String title;
    private String body;
    private String userId;
}
