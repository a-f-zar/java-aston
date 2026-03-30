package com.aston.adapter.service.legacy;

public class LegacySmsSender {

    public void sendSms(String phoneNumber, String text) {
        System.out.println("Отправка SMS на номер " + phoneNumber + ": " + text);
    }
}