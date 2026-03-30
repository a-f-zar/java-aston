package com.aston.chainofresponsibility.service.impl;

import com.aston.chainofresponsibility.domain.model.LoanProcessingResult;
import com.aston.chainofresponsibility.domain.model.LoanRequest;
import com.aston.chainofresponsibility.service.LoanHandler;

public class CreditHistoryCheckHandler extends LoanHandler {

    @Override
    protected LoanProcessingResult check(LoanRequest request) {
        if (!request.hasGoodCreditHistory()) {
            return LoanProcessingResult.rejected("Заявка отклонена: плохая кредитная история у " + request.getApplicantName());
        }

        return LoanProcessingResult.approved("Проверка кредитной истории пройдена для " + request.getApplicantName());
    }
}