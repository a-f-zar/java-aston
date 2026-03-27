package com.aston.decorator;

import com.aston.decorator.client.NotificationSender;
import com.aston.decorator.domain.model.Message;
import com.aston.decorator.service.Notification;
import com.aston.decorator.service.impl.BaseNotification;
import com.aston.decorator.service.impl.EmailNotificationDecorator;
import com.aston.decorator.service.impl.SmsNotificationDecorator;
import com.aston.decorator.service.impl.TelegramNotificationDecorator;

public class DecoratorDemo {

    public static void main(String[] args) {
        Message message = new Message("Заказ успешно оформлен");

        Notification notification = new BaseNotification();
        Notification emailNotification = new EmailNotificationDecorator(notification);
        Notification emailAndSmsNotification = new SmsNotificationDecorator(emailNotification);
        Notification fullNotification = new TelegramNotificationDecorator(emailAndSmsNotification);

        NotificationSender sender = new NotificationSender(fullNotification);
        sender.send(message);
    }
}