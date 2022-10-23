package io.sewah.fraud.repositories;
import io.sewah.fraud.entities.FraudCheckHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FraudRepository extends JpaRepository<FraudCheckHistory, Integer> {
}
