package com.pje.testapp.customer.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import com.pje.testapp.customer.dto.CustomerDto;
import com.pje.testapp.customer.entity.Customer;

public class CustomerMapperTest {

    private static  CustomerMapper customerMapper;

    static {
        customerMapper = Mappers.getMapper(CustomerMapper.class);
    }

    @Test
    public void getCustomerDtoTestSuccess(){
        Customer customer = new Customer();
        customer.setCustomerReference("test");
        customer.setCustomerName("Prashant");
        customer.setAddressLine1("reet");
        customer.setAddressLine2("dfs");

        CustomerDto dto =  customerMapper.getCustomerDto(customer);

        assertEquals(customer.getCustomerName(), dto.getCustomerName());
        assertEquals(customer.getCustomerReference(), dto.getCustomerReference());
        assertEquals(customer.getAddressLine1(), dto.getAddressLine1());
        assertEquals(customer.getAddressLine2(), dto.getAddressLine2());

    }

    @Test
    public void getCustomerEntityCustomer(){
        CustomerDto customer = new CustomerDto();
        customer.setCustomerReference("test");
        customer.setCustomerName("Prashant");
        customer.setAddressLine1("reet");
        customer.setAddressLine2("dfs");

        Customer entity =  customerMapper.getCustomerEntity(customer);

        assertEquals(customer.getCustomerName(), entity.getCustomerName());
        assertEquals(customer.getCustomerReference(), entity.getCustomerReference());
        assertEquals(customer.getAddressLine1(), entity.getAddressLine1());
        assertEquals(customer.getAddressLine2(), entity.getAddressLine2());

    }



}
