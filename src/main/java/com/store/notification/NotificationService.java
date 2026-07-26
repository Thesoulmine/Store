package com.store.notification;

public interface NotificationService {
    void sendEmailNotification(String toAddress, MailMessageTemplate mailMessageTemplate);
}
