package io.sewah.fraud.repositories;
import io.sewah.fraud.entities.Fraud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FraudRepository extends JpaRepository<Fraud, Integer> {
    Optional<Fraud> findByEmail(String email);
}
