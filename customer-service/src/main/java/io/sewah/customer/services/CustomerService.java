package io.sewah.customer.services;

import io.sewah.customer.dto.CustomerRequest;

public interface CustomerService {

    public String registerNewCustomer(CustomerRequest customerRequest);

}
