package com.demo.kafkaDemo.kafka;

import com.demo.kafkaDemo.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {

    private static final Logger LOGGER= LoggerFactory.getLogger(JsonKafkaProducer.class);

    @KafkaListener(topics = "topic2", groupId = "myGroup")
    public void consume(User user){
        LOGGER.info(String.format("Json Message Received -> %s",user.toString()));
    }
}
