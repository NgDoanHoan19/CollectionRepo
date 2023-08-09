package com.example.collection.service.impl;

import com.example.collection.constain.ApiCode;
import com.example.collection.constain.Constants;
import com.example.collection.dto.request.StudentCreateRequest;
import com.example.collection.exception.ServerException;
import com.example.collection.utils.ExcelUtil;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class KafkaProducerService {
    private static final Logger logger = LoggerFactory.getLogger(KafkaProducerService.class);

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        logger.info(String.format("Message sent -%s", message));
        CompletableFuture<SendResult<String, String>> send = kafkaTemplate.send(Constants.TOPIC_NAME, message);
    }

    public void sendData(MultipartFile file) {
        try {
            InputStream inputStream = file.getInputStream();



            List<StudentCreateRequest> studentList = ExcelUtil.excelStudent(inputStream);
            Gson gson = new Gson();
            String jsonData = gson.toJson(studentList);
            kafkaTemplate.send(Constants.TOPIC_NAME, jsonData);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            throw new ServerException(ApiCode.UNKNOWN_ERROR);
        }


    }
}
