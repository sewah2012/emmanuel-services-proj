package io.sewah.clients.notifications.dto;

import java.time.LocalDateTime;

public record NotificationRequest(
        String message,
        Integer toCustomerId,
        String toCustomerEmail
) {
}
