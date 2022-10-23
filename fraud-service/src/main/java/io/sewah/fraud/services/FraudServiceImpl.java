package io.sewah.fraud.services;

import io.sewah.customer.exceptions.errors.AlreadyExistException;
import io.sewah.fraud.dto.FraudRequest;
import io.sewah.fraud.entities.Fraud;
import io.sewah.fraud.repositories.FraudRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public record FraudServiceImpl(FraudRepository fraudRepository) implements FraudService {
    @Override
    public String registerNewFraud(FraudRequest fraudRequest) {
        fraudRepository.findByEmail(fraudRequest.email()).ifPresentOrElse(
                (customer)->{
                   throw new AlreadyExistException("A customer already with this email.");
                },
                ()->{
                    fraudRepository.save(Fraud.builder()
                            .email(fraudRequest.email())
                            .firstName(fraudRequest.firstName())
                            .lastName(fraudRequest.lastName())
                            .build());
                }
        );

        return "Fraud successfully saved";

    }
}
