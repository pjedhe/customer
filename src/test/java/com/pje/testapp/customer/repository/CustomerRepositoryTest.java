package com.pje.testapp.customer.repository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pje.testapp.customer.entity.Customer;

@SpringBootTest
public class CustomerRepositoryTest {



    @Autowired
    private CustomerRepository  cusCustomerRepository;

    public Customer setUp() {
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

    @Test
    public void testSaveAndFetchByReferenceSuccess() {

        Customer customer = setUp();
        cusCustomerRepository.saveAndFlush(customer);

        Optional<Customer> cust = cusCustomerRepository.findByCustomerReference("test");
        assertTrue(cust.isPresent());
    }

    @Test
    public void testFetchByReferenceFetch() {

        Optional<Customer> cust = cusCustomerRepository.findByCustomerReference("test");
        assertFalse(cust.isPresent());
    }

}
