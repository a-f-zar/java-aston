package com.aston.proxy.domain.model;

public class Document {

    private final String title;
    private final String content;
    private final boolean restricted;

    public Document(String title, String content, boolean restricted) {
        this.title = title;
        this.content = content;
        this.restricted = restricted;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public boolean isRestricted() {
        return restricted;
    }
}