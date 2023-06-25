package com.example.collection.controller;

import com.example.collection.service.impl.KafkaConsumerService;
import com.example.collection.service.impl.KafkaProducerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka/student")
public class KafkaProducerController {

    private final KafkaProducerService kafkaProducerService;
    private final KafkaConsumerService kafkaConsumerService;

    public KafkaProducerController(KafkaProducerService kafkaProducerService, KafkaConsumerService kafkaConsumerService) {
        this.kafkaProducerService = kafkaProducerService;
        this.kafkaConsumerService = kafkaConsumerService;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestBody String message){
        kafkaProducerService.sendMessage(message);
        return ResponseEntity.ok("Message sent into kafka success!");
    }
}
