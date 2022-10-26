package io.sewah.notificaton.rabbitmq;

import io.sewah.clients.notifications.dto.NotificationRequest;
import io.sewah.notificaton.services.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class NotificationConsumer {
     private final NotificationService notificationService;
    @RabbitListener(queues = "${rabbitmq.queues.notification}")
     public void consume(NotificationRequest notificationRequest){
        log.info("Consumed {} from queue", notificationRequest);
        notificationService.sendNotification(notificationRequest);
    }
}
