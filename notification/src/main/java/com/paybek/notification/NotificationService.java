package com.paybek.notification;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

// Bahodir Hasanov 9/22/2022 6:35 PM
@Service
@AllArgsConstructor
public class NotificationService {
    private final NotificationRepository notificationRepository;

    public void send(NotificationRequest notificationRequest) {
        notificationRepository.save(
                Notification.builder()
                        .toCostumerId(notificationRequest.toCustomerId())
                        .toCostumerEmail(notificationRequest.toCustomerEmail())
                        .sender("Paybek")
                        .message(notificationRequest.message())
                        .sentAt(LocalDateTime.now())
                        .build()
        );
    }
}
