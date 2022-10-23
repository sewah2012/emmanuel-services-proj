package io.sewah.fraud.services;

import io.sewah.clients.fraud.dto.FraudCheckResponse;
import io.sewah.fraud.entities.FraudCheckHistory;
import io.sewah.fraud.repositories.FraudRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public record FraudServiceImpl(FraudRepository fraudRepository) implements FraudService {
    @Override
    public FraudCheckResponse isFradulent(Integer customerId) {
        fraudRepository.save(FraudCheckHistory.builder()
                        .customerId(customerId)
                        .isFraudster(false)
                        .createdAt(LocalDateTime.now())
                .build());
        return new FraudCheckResponse(false);

    }
}
