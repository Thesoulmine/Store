package com.macalicestore.notification.message.mail;

public interface NotificationService {
    void sendEmailNotification(String toAddress,
                               MailMessageTemplate mailMessageTemplate);
}
