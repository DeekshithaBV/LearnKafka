package com.example.learn.kafka;

import com.example.learn.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service //to make this class spring bean
public class JsonKafkaProducer {
     private static final Logger log = LoggerFactory.getLogger(JsonKafkaProducer.class);

     private KafkaTemplate<String, User> kafkaTemplate;

   @Autowired // Not required, spring will add by default when there is only 1 parameterized constructor
    public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(User data){
       log.info(String.format("Message sent -> %s",data.toString()));
        Message<User> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, "learnJson")
                .build();

        kafkaTemplate.send(message);


    }
}
