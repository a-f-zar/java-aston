package com.aston.decorator.service;

import com.aston.decorator.domain.model.Message;

public interface Notification {

    void send(Message message);
}