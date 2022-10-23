package io.sewah.clients.notifications;

import io.sewah.clients.notifications.dto.NotificationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "NOTIFICATION-SERVICE", path = "/api/v1/notifications")
public interface NotificationClient {

    @PostMapping("/send-notification")
    public ResponseEntity<String> sendNotification(@RequestBody NotificationRequest notificationRequest);
}
