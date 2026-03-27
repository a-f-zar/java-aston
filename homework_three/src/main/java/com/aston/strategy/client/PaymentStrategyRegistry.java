package com.aston.strategy.client;

import com.aston.strategy.domain.enums.PaymentType;
import com.aston.strategy.service.PaymentStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaymentStrategyRegistry {

    private final Map<PaymentType, PaymentStrategy> strategies = new HashMap<>();

    public PaymentStrategyRegistry(List<PaymentStrategy> strategyList) {
        for (PaymentStrategy strategy : strategyList) {
            if (strategies.containsKey(strategy.getType())) {
                throw new IllegalStateException("Duplicate strategy for type: " + strategy.getType());
            }
            strategies.put(strategy.getType(), strategy);
        }
    }

    public PaymentStrategy getStrategy(PaymentType type) {
        PaymentStrategy strategy = strategies.get(type);

        if (strategy == null) {
            throw new IllegalArgumentException("No strategy found for payment type: " + type);
        }

        return strategy;
    }
}