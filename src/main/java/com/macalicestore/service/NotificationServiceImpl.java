package com.macalicestore.service;

import com.macalicestore.notification.message.mail.MailMessageTemplate;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;

import java.io.*;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final RabbitTemplate rabbitTemplate;
    private final JavaMailSender javaMailSender;
    private final TemplateEngine templateEngine;
    private final String fromMailAddress;
    private final String notificationQueueName;

    public NotificationServiceImpl(RabbitTemplate rabbitTemplate,
                                   JavaMailSender javaMailSender,
                                   TemplateEngine templateEngine,
                                   @Value("${mail.from.address}") String fromMailAddress,
                                   @Value("${notification.queue.name}") String notificationQueueName) {
        this.rabbitTemplate = rabbitTemplate;
        this.javaMailSender = javaMailSender;
        this.templateEngine = templateEngine;
        this.fromMailAddress = fromMailAddress;
        this.notificationQueueName = notificationQueueName;
    }

    @Override
    public void sendEmailNotification(String toAddress,
                                      MailMessageTemplate mailMessageTemplate) {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        try {
            helper.setFrom(fromMailAddress);
            helper.setTo(toAddress);
            helper.setSubject(mailMessageTemplate.getMailSubject());
            helper.setText(templateEngine.process(
                            mailMessageTemplate.getMailTemplateName(),
                            mailMessageTemplate.getContext()),
                    true);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            message.writeTo(outputStream);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        rabbitTemplate.convertAndSend(notificationQueueName, outputStream.toByteArray());
    }

    @RabbitListener(queues = "${notification.queue.name}")
    private void processEmailNotification(byte[] message) {
        javaMailSender.send(javaMailSender.createMimeMessage(new ByteArrayInputStream(message)));
    }
}
