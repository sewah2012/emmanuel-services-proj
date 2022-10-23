package io.sewah.fraud.services;
import io.sewah.fraud.dto.FraudRequest;

public interface FraudService {

    public String registerNewFraud(FraudRequest fraudRequest);

}
