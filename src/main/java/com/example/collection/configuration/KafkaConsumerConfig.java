package com.example.collection.configuration;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class KafkaConsumerConfig {

    @Value("${spring.kafka.consumer.bootstrap-servers}")
    private String bootstrapServers;

    public Map<String, Object> consumerConfig(){
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        objectMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        objectMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        return objectMap;
    }

    @Bean
    public ConsumerFactory<String, String> consumerFactory(){
        return new DefaultKafkaConsumerFactory<>(consumerConfig());
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListener(){
        ConcurrentKafkaListenerContainerFactory<String, String> obj = new ConcurrentKafkaListenerContainerFactory<>();
        obj.setConsumerFactory(consumerFactory());
        return obj;
    }
}
