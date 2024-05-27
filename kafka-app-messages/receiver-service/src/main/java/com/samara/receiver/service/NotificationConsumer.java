package com.samara.receiver.service;

import com.samara.dto.NotificationEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationConsumer {

    @KafkaListener(topics = "notifications-topic", groupId = "my-group-id")
    public void listen(NotificationEvent notification) {
        System.out.println("Received notification: " + notification.toString());
    }

}