package com.aston.strategy.client;

import com.aston.strategy.domain.model.Order;
import com.aston.strategy.service.PaymentStrategy;

public class PaymentProcessor {

    private final PaymentStrategyRegistry registry;

    public PaymentProcessor(PaymentStrategyRegistry registry) {
        this.registry = registry;
    }

    public void processPayment(Order order) {
        PaymentStrategy strategy = registry.getStrategy(order.getPaymentType());
        strategy.pay(order);
    }
}