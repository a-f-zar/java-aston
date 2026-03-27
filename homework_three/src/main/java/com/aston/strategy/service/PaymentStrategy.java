package com.aston.strategy.service;

import com.aston.strategy.domain.enums.PaymentType;
import com.aston.strategy.domain.model.Order;

public interface PaymentStrategy {

    void pay(Order order);

    PaymentType getType();
}