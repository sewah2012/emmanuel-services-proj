package io.sewah.notificaton.services;
import io.sewah.clients.notifications.dto.NotificationRequest;
import io.sewah.notificaton.entities.Notification;
import io.sewah.notificaton.repositories.NotificationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public record NotificationServiceImpl(NotificationRepository notificationRepository) implements NotificationService {
    @Override
    public String sendNotification(NotificationRequest notificationRequest) {

        notificationRepository.saveAndFlush(
                Notification.builder()
                        .message(notificationRequest.message())
                        .toCustomerEmail(notificationRequest.toCustomerEmail())
                        .toCustomerId(notificationRequest.toCustomerId())
                        .sender("Emmanuel Sewah")
                        .sentAt(LocalDateTime.now())
                        .build()
        );
        return "Notification send successfully";
    }
}
