package com.samara.sender.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

// Class Responsible To Create Topics
@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic notificationTopic() {
        return TopicBuilder
                .name("notifications-topic")
                .partitions(3)
                .build();
    }

    /*
    OR ...
    @Bean
    public NewTopic myTopic() {
        // Parameters: name, Optional.of(numPartitions), Optional.of(replicationFactor)
        return new NewTopic("topic-name", 1, (short) 1);
    }
    */
}
