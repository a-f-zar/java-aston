package com.aston.strategy.domain.model;

import com.aston.strategy.domain.enums.PaymentType;

public class Order {

    private final long id;
    private final double amount;
    private final PaymentType paymentType;

    public Order(long id, double amount, PaymentType paymentType) {
        this.id = id;
        this.amount = amount;
        this.paymentType = paymentType;
    }

    public long getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }
}