package com.aston.chainofresponsibility.service.impl;

import com.aston.chainofresponsibility.domain.model.LoanProcessingResult;
import com.aston.chainofresponsibility.domain.model.LoanRequest;
import com.aston.chainofresponsibility.service.LoanHandler;

import java.math.BigDecimal;

public class IncomeCheckHandler extends LoanHandler {

    private static final BigDecimal MIN_INCOME = new BigDecimal("50000");

    @Override
    protected LoanProcessingResult check(LoanRequest request) {
        if (request.getMonthlyIncome().compareTo(MIN_INCOME) < 0) {
            return LoanProcessingResult.rejected("Заявка отклонена: недостаточный доход у " + request.getApplicantName());
        }

        return LoanProcessingResult.approved("Проверка дохода пройдена для " + request.getApplicantName());
    }
}
