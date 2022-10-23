package io.sewah.customer.controllers;

import io.sewah.customer.dto.CustomerRequest;
import io.sewah.customer.services.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
@Slf4j
public record CustomerController(CustomerService customerService) {

    @PostMapping("/register-customer")
    public void registerCustomer(@RequestBody CustomerRequest customerRequest){
        log.info("new customer registration: {}", customerRequest);
        customerService.registerNewCustomer(customerRequest);
    }
}
