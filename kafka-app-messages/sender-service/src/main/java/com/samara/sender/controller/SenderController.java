package com.samara.sender.controller;

import com.samara.dto.NotificationEvent;
import com.samara.sender.service.SenderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sender")
public class SenderController {

    private final SenderService senderService;

    public SenderController(SenderService senderService) {
        this.senderService = senderService;
    }

    @PostMapping("/send-notification")
    public ResponseEntity<String> sendNotification(@RequestBody NotificationEvent notification) {
        senderService.sendNotification(notification);
        return ResponseEntity.status(HttpStatus.CREATED).body("Notification sent: " + notification);
    }

}
