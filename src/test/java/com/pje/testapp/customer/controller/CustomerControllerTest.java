package com.pje.testapp.customer.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.pje.testapp.customer.dto.CustomerDto;
import com.pje.testapp.customer.dto.ResponseDto;
import com.pje.testapp.customer.service.impl.CustomerService;

@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest {


    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    CustomerDto customer;

    @BeforeEach
    public void setup(){
        customer = new CustomerDto();
        customer.setCustomerReference("test");
        customer.setCustomerName("Prashant");
        customer.setAddressLine1("reet");
        customer.setAddressLine2("dfs");
    }

    @Test
    public void saveCustomerTest() throws Exception{
        MockHttpServletRequest request =  new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        
        when(customerService.storeCustomer(customer)).thenReturn(customer);

        ResponseEntity<ResponseDto> responseEntity = customerController.createCustomer(customer);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.CREATED);
    }
    

    @SuppressWarnings("null")
    @Test
    public void fetchCustomerTest() throws Exception{
        MockHttpServletRequest request =  new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        
        when(customerService.getCustomer(customer.getCustomerReference())).thenReturn(customer);

        ResponseEntity<CustomerDto> responseEntity = customerController.fetchCustomerDetails(customer.getCustomerReference());
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        assertEquals(responseEntity.getBody().getCustomerName(), customer.getCustomerName());

    }

}
