package com.pje.testapp.customer.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pje.testapp.customer.dto.CustomerDto;
import com.pje.testapp.customer.service.impl.CustomerService;

public class CustomerControllerTest {
@Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    @Autowired
    private ObjectMapper objectMapper;

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
        // precondition

    }

}
