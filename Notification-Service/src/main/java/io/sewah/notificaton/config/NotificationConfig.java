package io.sewah.notificaton.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationConfig {
    @Value("${rabbitmq.exchange.internal")
    private String internalExchange;

    @Value("${rabbitmq.queues.notification")
    private String notificationQueue;

    @Value("${rabbitmq.routing-keys.internal-notification")
    private String internalNotificationRoutingKeys;




}
