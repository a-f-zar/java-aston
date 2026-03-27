package com.aston.decorator.service.impl;

import com.aston.decorator.domain.model.Message;
import com.aston.decorator.service.Notification;
import com.aston.decorator.service.NotificationDecorator;

public class SmsNotificationDecorator extends NotificationDecorator {

    public SmsNotificationDecorator(Notification notification) {
        super(notification);
    }

    @Override
    public void send(Message message) {
        super.send(message);
        System.out.println("Дополнительно отправлено SMS: " + message.getText());
    }
}