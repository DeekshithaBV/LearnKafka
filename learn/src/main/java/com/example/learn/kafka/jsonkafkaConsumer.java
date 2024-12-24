package com.example.learn.kafka;

import com.example.learn.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class jsonkafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "learnJson", groupId = "myGroup") // to subscribe to topic
    public void consume(User user) {
        LOGGER.info(String.format("JSON Message recieved -> %s", user.toString()));
    }
}
