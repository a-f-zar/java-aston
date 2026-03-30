package com.aston.adapter;

import com.aston.adapter.client.NotificationProcessor;
import com.aston.adapter.service.NotificationService;
import com.aston.adapter.service.adapter.SmsNotificationAdapter;
import com.aston.adapter.service.impl.EmailNotificationService;
import com.aston.adapter.service.legacy.LegacySmsSender;

public class AdapterDemo {

    public static void main(String[] args) {
        NotificationService emailService = new EmailNotificationService();
        NotificationProcessor emailProcessor = new NotificationProcessor(emailService);
        emailProcessor.process("user@example.com", "Добро пожаловать в систему!");
        System.out.println();

        LegacySmsSender legacySmsSender = new LegacySmsSender();
        NotificationService smsAdapter = new SmsNotificationAdapter(legacySmsSender);
        NotificationProcessor smsProcessor = new NotificationProcessor(smsAdapter);
        smsProcessor.process("+79991234567", "Ваш код подтверждения: 1234");
    }
}