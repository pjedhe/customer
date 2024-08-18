package com.pje.testapp.customer.mapper;

import org.mapstruct.Mapper;

import com.pje.testapp.customer.dto.CustomerDto;
import com.pje.testapp.customer.entity.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    Customer getCustomerEntity(CustomerDto customerDto);
    CustomerDto getCustomerDto(Customer customer);

}
