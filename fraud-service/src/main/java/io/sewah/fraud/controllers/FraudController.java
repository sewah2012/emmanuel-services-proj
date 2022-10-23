package io.sewah.fraud.controllers;
import io.sewah.fraud.dto.FraudRequest;
import io.sewah.fraud.services.FraudService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
@Slf4j
public record FraudController(FraudService fraudService) {

    @PostMapping("/register-fraud")
    public ResponseEntity<String> registerCustomer(@RequestBody FraudRequest fraudRequest){
        log.info("new customer registration: {}", fraudRequest);
        return ResponseEntity.ok(fraudService.registerNewFraud(fraudRequest));
    }
}
