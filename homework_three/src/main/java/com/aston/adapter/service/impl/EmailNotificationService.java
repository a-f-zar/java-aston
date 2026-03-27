package com.aston.adapter.service.impl;

import com.aston.adapter.service.NotificationService;

public class EmailNotificationService implements NotificationService {

    @Override
    public void sendNotification(String recipient, String message) {
        System.out.println("Отправка Email на " + recipient + ": " + message);
    }
}