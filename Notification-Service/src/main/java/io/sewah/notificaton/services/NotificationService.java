package io.sewah.notificaton.services;

import io.sewah.clients.notifications.dto.NotificationRequest;

public interface NotificationService {

    public String sendNotification(NotificationRequest notificationRequest);

}
