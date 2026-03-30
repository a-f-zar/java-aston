package com.aston.decorator.service;

import com.aston.decorator.domain.model.Message;

public abstract class NotificationDecorator implements Notification {

    protected final Notification notification;

    public NotificationDecorator(Notification notification) {
        this.notification = notification;
    }

    @Override
    public void send(Message message) {
        notification.send(message);
    }
}