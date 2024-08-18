package com.pje.testapp.customer.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.pje.testapp.customer.dto.CustomerDto;
import com.pje.testapp.customer.entity.Customer;
import com.pje.testapp.customer.exception.CustomerAlreadyExistsException;
import com.pje.testapp.customer.exception.ResourceNotFoundException;
import com.pje.testapp.customer.mapper.CustomerMapper;
import com.pje.testapp.customer.repository.CustomerRepository;
import com.pje.testapp.customer.service.impl.CustomerService;

@SpringBootTest
public class CustomerServiceTest {

    @MockBean
    private CustomerRepository customerRepository;

    @MockBean
    private CustomerMapper customerMapper;

    ICustomerService iCustomerService;

    @BeforeEach
    public void setUp() {
        iCustomerService = new CustomerService(customerRepository, customerMapper);

    }

    @Test
    public void storeCustomerTestSuccess(){
        CustomerDto dto = testDataDto();
        when(customerRepository.findByCustomerReference(anyString())).thenReturn(Optional.empty());
        when(customerMapper.getCustomerEntity(dto)).thenReturn(testDataEntity());
        iCustomerService.storeCustomer(dto);
    }

    @Test
    public void storeCustomerTestFailed(){
        CustomerDto dto = testDataDto();
        when(customerRepository.findByCustomerReference(anyString())).thenReturn(Optional.of(testDataEntity()));
        when(customerMapper.getCustomerEntity(dto)).thenReturn(testDataEntity());

        CustomerAlreadyExistsException exception = assertThrows(CustomerAlreadyExistsException.class, ()->iCustomerService.storeCustomer(dto));
        assertEquals("Customer already exist with given customeReference " + dto.getCustomerReference(), exception.getMessage());
        
    }

    @Test
    public void getCustomerSuccess(){
        Customer entity = testDataEntity();
        when(customerRepository.findByCustomerReference(anyString())).thenReturn(Optional.of(entity));
        when(customerMapper.getCustomerDto(entity)).thenReturn(testDataDto());
        CustomerDto customerDtoRes = iCustomerService.getCustomer(entity.getCustomerReference());
        assertEquals(entity.getCustomerName(), customerDtoRes.getCustomerName());
        assertEquals(entity.getPostcode(), customerDtoRes.getPostcode());

    }

    @Test
    public void getCustomerFailed(){
        when(customerRepository.findByCustomerReference(anyString())).thenReturn(Optional.empty());

        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class, ()->iCustomerService.getCustomer("TEST"));
        assertEquals("Customer not found with the given input data customerReference : 'TEST'", exception.getMessage());

    }

    public CustomerDto  testDataDto() {
        CustomerDto customer = new CustomerDto();
        customer.setCustomerReference("test");
        customer.setCustomerName("Prashant");
        customer.setAddressLine1("reet");

        customer.setAddressLine2("dfs");
        customer.setCounty("County");
        customer.setCountry("UK");
        customer.setTown("yfgygjh");
        customer.setPostcode("G77");
        return customer;
    }

    public Customer  testDataEntity() {
        Customer customer = new Customer();
        customer.setCustomerReference("test");
        customer.setCustomerName("Prashant");
        customer.setAddressLine1("reet");

        customer.setAddressLine2("dfs");
        customer.setCounty("County");
        customer.setCountry("UK");
        customer.setTown("yfgygjh");
        customer.setPostcode("G77");
        return customer;
    }
}
