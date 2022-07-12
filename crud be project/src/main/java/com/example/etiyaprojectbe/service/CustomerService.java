package com.example.etiyaprojectbe.service;

import com.example.etiyaprojectbe.entity.Customer;

import java.util.List;

public interface CustomerService {

    Customer createCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    void deleteCustomer(Customer customer);
    List<Customer> listCustomer();
    Customer ListCustomerId(int id);


}
