package io.sewah.customer.services;

import io.sewah.customer.dto.CustomerRequest;
import io.sewah.customer.entities.Customer;
import io.sewah.customer.exceptions.errors.AlreadyExistException;
import io.sewah.customer.repositories.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public record CustomerServiceImpl(CustomerRepository customerRepository) implements CustomerService {
    @Override
    public String registerNewCustomer(CustomerRequest customerRequest) {
        customerRepository().findByEmail(customerRequest.email()).ifPresentOrElse(
                (customer)->{
                   throw new AlreadyExistException("A customer already with this email.");
                },
                ()->{
                    customerRepository.save(Customer.builder()
                            .email(customerRequest.email())
                            .firstName(customerRequest.firstName())
                            .lastName(customerRequest.lastName())
                            .build());
                }
        );

        return "Customer successfully saved";

    }
}
