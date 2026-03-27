package com.aston.chainofresponsibility.client;

import com.aston.chainofresponsibility.domain.model.LoanProcessingResult;
import com.aston.chainofresponsibility.domain.model.LoanRequest;
import com.aston.chainofresponsibility.service.LoanHandler;

public class LoanProcessor {

    private final LoanHandler firstHandler;

    public LoanProcessor(LoanHandler firstHandler) {
        this.firstHandler = firstHandler;
    }

    public LoanProcessingResult process(LoanRequest request) {
        return firstHandler.handle(request);
    }
}