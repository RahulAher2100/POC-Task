package com.demo.kafkaDemo.controller;

import com.demo.kafkaDemo.kafka.JsonKafkaProducer;
import com.demo.kafkaDemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {

    @Autowired
    private JsonKafkaProducer jsonKafkaProducer;

    @PostMapping("/jsonPublish")
    public ResponseEntity<String> publish(@RequestBody User user){

        jsonKafkaProducer.sendMessage(user);

        return ResponseEntity.ok("Json Message send to Kafka topic ");
    }

}
