package com.aston.chainofresponsibility.domain.model;

import java.math.BigDecimal;

public class LoanRequest {

    private final String applicantName;
    private final BigDecimal amount;
    private final boolean goodCreditHistory;
    private final BigDecimal monthlyIncome;

    public LoanRequest(String applicantName, BigDecimal amount, boolean goodCreditHistory, BigDecimal monthlyIncome) {
        this.applicantName = applicantName;
        this.amount = amount;
        this.goodCreditHistory = goodCreditHistory;
        this.monthlyIncome = monthlyIncome;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public boolean hasGoodCreditHistory() {
        return goodCreditHistory;
    }

    public BigDecimal getMonthlyIncome() {
        return monthlyIncome;
    }
}