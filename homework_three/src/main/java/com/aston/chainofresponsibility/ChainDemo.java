package com.aston.chainofresponsibility;

import com.aston.chainofresponsibility.client.LoanProcessor;
import com.aston.chainofresponsibility.domain.model.LoanProcessingResult;
import com.aston.chainofresponsibility.domain.model.LoanRequest;
import com.aston.chainofresponsibility.service.LoanHandler;
import com.aston.chainofresponsibility.service.impl.AmountCheckHandler;
import com.aston.chainofresponsibility.service.impl.CreditHistoryCheckHandler;
import com.aston.chainofresponsibility.service.impl.FinalApprovalHandler;
import com.aston.chainofresponsibility.service.impl.IncomeCheckHandler;

import java.math.BigDecimal;

public class ChainDemo {

    public static void main(String[] args) {
        LoanHandler chain = new AmountCheckHandler();
        chain.setNext(new CreditHistoryCheckHandler()).setNext(new IncomeCheckHandler()).setNext(new FinalApprovalHandler());

        LoanProcessor processor = new LoanProcessor(chain);

        processRequest(processor, new LoanRequest("Airat", new BigDecimal("300000"), true, new BigDecimal("80000")));
        processRequest(processor, new LoanRequest("Ivan", new BigDecimal("700000"), true, new BigDecimal("90000")));
        processRequest(processor, new LoanRequest("Ольга", new BigDecimal("200000"), false, new BigDecimal("100000")));
        processRequest(processor, new LoanRequest("Мария", new BigDecimal("150000"), true, new BigDecimal("30000")));
    }

    private static void processRequest(LoanProcessor processor, LoanRequest request) {
        System.out.println("=== Обработка заявки для " + request.getApplicantName() + " ===");
        LoanProcessingResult result = processor.process(request);
        System.out.println(result.getMessage());
        System.out.println();
    }
}