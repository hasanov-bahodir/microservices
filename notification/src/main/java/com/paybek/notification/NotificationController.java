package com.paybek.notification;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Bahodir Hasanov 9/22/2022 6:29 PM
@AllArgsConstructor
@Slf4j
@RestController
@RequestMapping("api/v1/notification")
public class NotificationController {
    private final NotificationService notificationService;

    @PostMapping
    public void sendNotification(@RequestBody NotificationRequest notificationRequest) {
        log.info("New notification ... {}", notificationRequest);
        notificationService.send(notificationRequest);
    }
}
