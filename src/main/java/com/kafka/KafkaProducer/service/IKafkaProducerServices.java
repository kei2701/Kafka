package com.kafka.KafkaProducer.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface IKafkaProducerServices {
    void fetchAndSendPostData() throws JsonProcessingException;
}
