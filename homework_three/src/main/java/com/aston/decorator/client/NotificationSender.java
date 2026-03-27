package com.aston.decorator.client;

import com.aston.decorator.domain.model.Message;
import com.aston.decorator.service.Notification;

public class NotificationSender {

    private final Notification notification;

    public NotificationSender(Notification notification) {
        this.notification = notification;
    }

    public void send(Message message) {
        notification.send(message);
    }
}