package com.aston.adapter.client;

import com.aston.adapter.service.NotificationService;

public class NotificationProcessor {

    private final NotificationService notificationService;

    public NotificationProcessor(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void process(String recipient, String message) {
        notificationService.sendNotification(recipient, message);
    }
}