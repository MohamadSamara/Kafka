package com.samara.sender.service;

import com.samara.dto.NotificationEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class SenderService {

    private final KafkaTemplate<String, NotificationEvent> kafkaNotificationTemplate;

    public SenderService(KafkaTemplate<String, NotificationEvent> kafkaNotificationTemplate) {
        this.kafkaNotificationTemplate = kafkaNotificationTemplate;
    }


    // Send Event To Topic
    public void sendNotification(NotificationEvent notification) {

        try {
            CompletableFuture<SendResult<String, NotificationEvent>> future =
                    kafkaNotificationTemplate.send("notifications-topic", notification);

            future.whenComplete((result, exception) -> {
                if (exception == null) {
                    log.info("Notification sent successfully : {}", notification.toString() + "\n"
                            + "with offset : " + result.getRecordMetadata().offset());
                } else {
                    log.info("Notification sent failed : {}", notification.toString() + "\n"
                            + "due to : " + exception.getMessage());
                }
            });
        } catch (Exception e) {
            log.info("Error ::: {}", e.getMessage());
        }
    }
}
