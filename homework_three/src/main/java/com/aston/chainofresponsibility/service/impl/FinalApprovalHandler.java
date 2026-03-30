package com.aston.chainofresponsibility.service.impl;

import com.aston.chainofresponsibility.domain.model.LoanProcessingResult;
import com.aston.chainofresponsibility.domain.model.LoanRequest;
import com.aston.chainofresponsibility.service.LoanHandler;

public class FinalApprovalHandler extends LoanHandler {

    @Override
    protected LoanProcessingResult check(LoanRequest request) {
        return LoanProcessingResult.approved("Заявка одобрена для " + request.getApplicantName());
    }
}