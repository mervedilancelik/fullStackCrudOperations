package com.example.etiyaprojectbe.controller;

import com.example.etiyaprojectbe.entity.Customer;
import com.example.etiyaprojectbe.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Dış dünyadan gelen customer isteklerini karşılayan sınıf
 */

@RestController
@RequestMapping("/api/customer")
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    /**
     * Customer listeleme isteklerini karşılayan motod
     *
     * @return dönen değer customerların listesi
     */
    @GetMapping("/list")
    public List<Customer> getAllCustomer() {
        return customerService.listCustomer();
    }

    /**
     * Customer oluşturma isteklerini karşılayan motod
     *
     * @param customer
     * @return dönen değer yaratılan customer nesnesi
     */
    @PostMapping("/create")
    public Customer create(@RequestBody Customer customer) {

        return customerService.createCustomer(customer);
    }

    /**
     * Customer güncelleme isteklerini karşılayan motod
     *
     * @param customer
     * @return dönen değer güncellenen customer nesnesi
     */

    @PostMapping("/update")
    public Customer update(@RequestBody Customer customer) {
        return customerService.updateCustomer(customer);
    }

    /**
     * Customer silme isteklerini karşılayan motod
     *
     * @param customer
     */

    @PostMapping("/delete")
    public void delete(@RequestBody Customer customer) {

        customerService.deleteCustomer(customer);
    }

    /**
     * Customerın id bilgisine göre  listeleme isteklerini karşılayan motod
     *
     * @param id
     * @return dönen değer id değerine göre listelenen customer nesnesi
     */

    @GetMapping(value = "/list/{id}")
    public Customer getCustomerById(@PathVariable int id) {
        return customerService.ListCustomerId(id);
    }

}
