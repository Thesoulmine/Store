package com.macalicestore.notification;

import org.thymeleaf.context.Context;

public class OrderCreatedMailMessageTemplate extends MailMessageTemplate {

    @Override
    public String getMailTemplateName() {
        return "messages/mail/order-created-mail-message";
    }

    @Override
    public String getMailSubject() {
        return "Ваш заказ был создан";
    }

    @Override
    protected void setContextVariables(Context context) {
        context.setVariable("firstName", "Иван");
        context.setVariable("lastName", "Иванов");
        context.setVariable("patronymic", "Иванович");
        context.setVariable("orderNumber", "123456");
    }
}
