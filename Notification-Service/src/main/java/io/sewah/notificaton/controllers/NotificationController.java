package io.sewah.notificaton.controllers;
import io.sewah.clients.notifications.dto.NotificationRequest;
import io.sewah.notificaton.services.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
@Slf4j
public record NotificationController(NotificationService notificationService) {

    @PostMapping("/send-notification")
    public ResponseEntity<String> sendNotification(@RequestBody NotificationRequest notificationRequest){
        return ResponseEntity.ok(notificationService.sendNotification(notificationRequest));
    }
}
