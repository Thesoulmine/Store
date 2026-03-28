package com.macalicestore.notification;

public interface NotificationService {
    void sendEmailNotification(String toAddress, MailMessageTemplate mailMessageTemplate);
}
