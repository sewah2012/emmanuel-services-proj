package io.sewah.customer.services;

import io.sewah.customer.dto.CustomerRequest;
import io.sewah.customer.dto.FraudCheckResponse;
import io.sewah.customer.entities.Customer;
import io.sewah.customer.exceptions.errors.AlreadyExistException;
import io.sewah.customer.exceptions.errors.FraudsterException;
import io.sewah.customer.repositories.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public record CustomerServiceImpl(CustomerRepository customerRepository, RestTemplate restTemplate) implements CustomerService {
    @Override
    public String registerNewCustomer(CustomerRequest customerRequest) {
        customerRepository().findByEmail(customerRequest.email()).ifPresentOrElse(
                (customer)->{
                   throw new AlreadyExistException("A customer already with this email.");
                },
                ()->{
                    var customer = customerRepository.saveAndFlush(Customer.builder()
                            .email(customerRequest.email())
                            .firstName(customerRequest.firstName())
                            .lastName(customerRequest.lastName())
                            .build());
                    //TODO: check if customer is fraudster
                   var response =  restTemplate.getForObject(
                        "http://localhost:8181/api/v1/frauds/check-fraud?customerId={customerId}",
                            FraudCheckResponse.class,
                            customer.getId()
                    );

                   if(response.isFraudster()) throw new FraudsterException("This customer is a Fraudster");

                }
        );

        return "Customer successfully saved";

    }
}
