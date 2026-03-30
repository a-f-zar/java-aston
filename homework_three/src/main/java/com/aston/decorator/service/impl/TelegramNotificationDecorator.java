package com.aston.decorator.service.impl;

import com.aston.decorator.domain.model.Message;
import com.aston.decorator.service.Notification;
import com.aston.decorator.service.NotificationDecorator;

public class TelegramNotificationDecorator extends NotificationDecorator {

    public TelegramNotificationDecorator(Notification notification) {
        super(notification);
    }

    @Override
    public void send(Message message) {
        super.send(message);
        System.out.println("Дополнительно отправлено в Telegram: " + message.getText());
    }
}