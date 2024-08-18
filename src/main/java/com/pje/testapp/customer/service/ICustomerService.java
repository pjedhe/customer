package com.pje.testapp.customer.service;

import com.pje.testapp.customer.dto.CustomerDto;

public interface ICustomerService {

    CustomerDto storeCustomer(CustomerDto customerDto); 

    CustomerDto getCustomer(String customerRef); 

}
