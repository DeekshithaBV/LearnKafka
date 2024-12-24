package com.example.learn.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic learnTopic(){
        return TopicBuilder.name("learn").build();
                //.partitions(10)
    }

    @Bean
    public NewTopic learnTopic_Json(){
        return TopicBuilder.name("learnJson").build();
        //.partitions(10)
    }
}
