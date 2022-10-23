package io.sewah.customer.services;

import io.sewah.customer.dto.CustomerRequest;
import io.sewah.customer.entities.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public record CustomerServiceImpl() implements CustomerService {
    @Override
    public void registerNewCustomer(CustomerRequest customerRequest) {
        log.info("persisting new customer information: {}", customerRequest);
        var customer = Customer.builder()
                .email(customerRequest.email())
                .firstName(customerRequest.firstName())
                .lastName(customerRequest.lastName())
                .build();

        //Todo: check if email is valid

        //Todo: check if email is not taken

        //Todo: save record into databalse


    }
}
