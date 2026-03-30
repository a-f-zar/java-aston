package com.aston.chainofresponsibility.domain.model;

public class LoanProcessingResult {

    private final boolean approved;
    private final String message;

    private LoanProcessingResult(boolean approved, String message) {
        this.approved = approved;
        this.message = message;
    }

    public static LoanProcessingResult approved(String message) {
        return new LoanProcessingResult(true, message);
    }

    public static LoanProcessingResult rejected(String message) {
        return new LoanProcessingResult(false, message);
    }

    public boolean isApproved() {
        return approved;
    }

    public String getMessage() {
        return message;
    }
}