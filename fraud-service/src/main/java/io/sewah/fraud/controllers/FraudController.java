package io.sewah.fraud.controllers;
import io.sewah.clients.fraud.dto.FraudCheckResponse;
import io.sewah.fraud.services.FraudService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/frauds")
@Slf4j
public record FraudController(FraudService fraudService) {

    @GetMapping("/check-fraud")
    public ResponseEntity<FraudCheckResponse> checkFraud(@RequestParam("customerId") Integer customerId){
        log.info("fraud check request for customer {}", customerId);
        return ResponseEntity.ok(fraudService.isFradulent(customerId));
    }
}
