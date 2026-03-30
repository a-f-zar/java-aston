package com.aston.strategy.service.impl;

import com.aston.strategy.domain.enums.PaymentType;
import com.aston.strategy.domain.model.Order;
import com.aston.strategy.service.PaymentStrategy;

public class CardPaymentStrategy implements PaymentStrategy {

    @Override
    public void pay(Order order) {
        System.out.println("Оплата заказа #" + order.getId() + " банковской картой на сумму " + order.getAmount());
    }

    @Override
    public PaymentType getType() {
        return PaymentType.CARD;
    }
}