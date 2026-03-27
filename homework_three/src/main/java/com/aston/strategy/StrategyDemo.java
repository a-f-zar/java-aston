package com.aston.strategy;

import com.aston.strategy.client.PaymentProcessor;
import com.aston.strategy.client.PaymentStrategyRegistry;
import com.aston.strategy.domain.enums.PaymentType;
import com.aston.strategy.domain.model.Order;
import com.aston.strategy.service.PaymentStrategy;
import com.aston.strategy.service.impl.CardPaymentStrategy;
import com.aston.strategy.service.impl.CashPaymentStrategy;
import com.aston.strategy.service.impl.PayPalPaymentStrategy;
import com.aston.strategy.service.impl.SBPPaymentStrategy;

import java.util.List;

public class StrategyDemo {

    public static void main(String[] args) {
        List<PaymentStrategy> strategies = List.of(
                new CardPaymentStrategy(),
                new PayPalPaymentStrategy(),
                new SBPPaymentStrategy(),
                new CashPaymentStrategy()
        );

        PaymentStrategyRegistry registry = new PaymentStrategyRegistry(strategies);
        PaymentProcessor processor = new PaymentProcessor(registry);

        Order order1 = new Order(1L, 1500.0, PaymentType.CARD);
        Order order2 = new Order(2L, 2300.0, PaymentType.PAYPAL);
        Order order3 = new Order(3L, 999.99, PaymentType.SBP);
        Order order4 = new Order(4L, 500.0, PaymentType.CASH);

        processor.processPayment(order1);
        processor.processPayment(order2);
        processor.processPayment(order3);
        processor.processPayment(order4);
    }
}