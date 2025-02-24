package com.macalicestore.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {


    private final String notificationQueueName;

    public RabbitMQConfig(@Value("${notification.queue.name}") String notificationQueueName) {
        this.notificationQueueName = notificationQueueName;
    }

    @Bean
    public Queue notificationQueue() {
        return new Queue(notificationQueueName, true);
    }
}
