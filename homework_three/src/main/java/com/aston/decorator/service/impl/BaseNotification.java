package com.aston.decorator.service.impl;

import com.aston.decorator.domain.model.Message;
import com.aston.decorator.service.Notification;

public class BaseNotification implements Notification {

    @Override
    public void send(Message message) {
        System.out.println("Базовое уведомление: " + message.getText());
    }
}