package com.pje.testapp.customer.service.impl;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.pje.testapp.customer.dto.CustomerDto;
import com.pje.testapp.customer.entity.Customer;
import com.pje.testapp.customer.exception.CustomerAlreadyExistsException;
import com.pje.testapp.customer.exception.ResourceNotFoundException;
import com.pje.testapp.customer.mapper.CustomerMapper;
import com.pje.testapp.customer.repository.CustomerRepository;
import com.pje.testapp.customer.service.ICustomerService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class CustomerService implements ICustomerService{

    private CustomerRepository customerRepository;

    private CustomerMapper customerMapper;

    @Override
    public CustomerDto storeCustomer(CustomerDto customerDto) {
        Optional<Customer> customerEntity = customerRepository.findByCustomerReference(customerDto.getCustomerReference());
        if(customerEntity.isPresent()) {
            throw new CustomerAlreadyExistsException("Customer already exist with given customeReference "
                    + customerDto.getCustomerReference());
        }
        Customer customer = customerMapper.getCustomerEntity(customerDto);
        customerRepository.save(customer);
        return customerDto;
    }

    @Override
    public CustomerDto getCustomer(String customerRef) {
        Customer customer = customerRepository.findByCustomerReference(customerRef).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "customerReference", customerRef)
        );
        return customerMapper.getCustomerDto(customer);

    }

}
