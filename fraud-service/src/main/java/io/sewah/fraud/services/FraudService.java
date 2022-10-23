package io.sewah.fraud.services;

import io.sewah.clients.fraud.dto.FraudCheckResponse;

public interface FraudService {

    public FraudCheckResponse isFradulent(Integer customerId);

}
