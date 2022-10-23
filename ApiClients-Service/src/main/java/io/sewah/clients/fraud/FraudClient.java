package io.sewah.clients.fraud;

import io.sewah.clients.fraud.dto.FraudCheckResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("FRAUD-SERVICE")
public interface FraudClient {
    @GetMapping(path = "api/v1/frauds/check-fraud")
    FraudCheckResponse isFraudSter(@RequestParam("customerId") Integer customerId);
}
