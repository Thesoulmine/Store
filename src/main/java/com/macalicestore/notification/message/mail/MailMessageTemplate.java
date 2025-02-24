package com.macalicestore.notification.message.mail;

import org.thymeleaf.context.Context;

public abstract class MailMessageTemplate {

    public abstract String getMailTemplateName();

    public abstract String getMailSubject();

    protected abstract void setContextVariables(Context context);

    public Context getContext() {
        Context context = new Context();

        setContextVariables(context);

        return context;
    }
}
