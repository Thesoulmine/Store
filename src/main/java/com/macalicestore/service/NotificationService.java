package com.macalicestore.service;

import com.macalicestore.notification.message.mail.MailMessageTemplate;

public interface NotificationService {
    void sendEmailNotification(String toAddress,
                               MailMessageTemplate mailMessageTemplate);
}
