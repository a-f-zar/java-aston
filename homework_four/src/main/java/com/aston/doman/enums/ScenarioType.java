package com.aston.doman.enums;

public enum ScenarioType {
    DEADLOCK(1, "deadlock"),
    LIVELOCK(2, "livelock"),
    ALTERNATE(3, "alternate");

    private final int number;
    private final String title;

    ScenarioType(int number, String title) {
        this.number = number;
        this.title = title;
    }

    public static ScenarioType fromNumber(String value) {
        for (ScenarioType type : values()) {
            if (String.valueOf(type.number).equals(value.trim())) {
                return type;
            }
        }
        return null;
    }

    public int getNumber() {
        return number;
    }

    public String getTitle() {
        return title;
    }
}
