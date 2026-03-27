package com.aston.chainofresponsibility.service.impl;

import com.aston.chainofresponsibility.domain.model.LoanProcessingResult;
import com.aston.chainofresponsibility.domain.model.LoanRequest;
import com.aston.chainofresponsibility.service.LoanHandler;

import java.math.BigDecimal;

public class AmountCheckHandler extends LoanHandler {

    private static final BigDecimal MAX_AMOUNT = new BigDecimal("500000");

    @Override
    protected LoanProcessingResult check(LoanRequest request) {
        if (request.getAmount().compareTo(MAX_AMOUNT) > 0) {
            return LoanProcessingResult.rejected("Заявка отклонена: сумма кредита слишком большая для " + request.getApplicantName());
        }

        return LoanProcessingResult.approved("Проверка суммы пройдена для " + request.getApplicantName());
    }
}