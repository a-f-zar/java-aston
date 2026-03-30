package com.aston.chainofresponsibility.service;

import com.aston.chainofresponsibility.domain.model.LoanProcessingResult;
import com.aston.chainofresponsibility.domain.model.LoanRequest;

public abstract class LoanHandler {

    private LoanHandler next;

    public LoanHandler setNext(LoanHandler next) {
        this.next = next;
        return next;
    }

    public LoanProcessingResult handle(LoanRequest request) {
        LoanProcessingResult result = check(request);

        if (!result.isApproved() || next == null) {
            return result;
        }

        return next.handle(request);
    }

    protected abstract LoanProcessingResult check(LoanRequest request);
}