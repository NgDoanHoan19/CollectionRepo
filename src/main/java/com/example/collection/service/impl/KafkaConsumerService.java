package com.example.collection.service.impl;

import com.example.collection.constain.Constants;
import com.example.collection.entities.Student;
import com.example.collection.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.gson.GsonBuilder;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class KafkaConsumerService {
    private final StudentRepository studentRepository;

    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);

    public KafkaConsumerService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @KafkaListener(topics = Constants.TOPIC_NAME, groupId = Constants.GROUP_ID)
    public void consume(String message){
        logger.info("data received!");
        List<Student> students = Arrays.asList(new GsonBuilder().create().fromJson(message, Student[].class));
        studentRepository.saveAll(students);
    }
}
