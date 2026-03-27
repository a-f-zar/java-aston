package com.aston.adapter.service.adapter;

import com.aston.adapter.service.NotificationService;
import com.aston.adapter.service.legacy.LegacySmsSender;

public class SmsNotificationAdapter implements NotificationService {

    private final LegacySmsSender legacySmsSender;

    public SmsNotificationAdapter(LegacySmsSender legacySmsSender) {
        this.legacySmsSender = legacySmsSender;
    }

    @Override
    public void sendNotification(String recipient, String message) {
        legacySmsSender.sendSms(recipient, message);
    }
}