package com.example.etiyaprojectbe.service.impl;
import com.example.etiyaprojectbe.entity.Customer;
import com.example.etiyaprojectbe.exception.ResourceNotFoundException;
import com.example.etiyaprojectbe.repository.CustomerRepository;
import com.example.etiyaprojectbe.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Customerlar ile ilgili süreçlerin  yönetildiği sınıf
 */


@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    /**
     * Customerların yartıldığı metod
     * @param customer
     * @return dönen değer yaratılan customer nesnesi
     */

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    /**
     * Customerların güncellendiği metod
     * @param customer
     * @return dönen değer güncellenen customer nesnesi
     */

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    /**
     * Customerların silindiği metod
     * @param customer
     */

    @Override
    public void deleteCustomer(Customer customer) {
        customerRepository.delete(customer);
    }

    /**
     * Tüm Customerların listelendiği method
     * @return dönen değer customerların listesi
     */

    @Override
    public List<Customer> listCustomer() {
        return customerRepository.findAll();
    }

    /**
     * Customerları id bilgisine göre  listeleyen motod
     * @param id
     * @return dönen değer id değerine göre listelenen customer nesnesi
     */
    @Override
    public Customer ListCustomerId(int id) {

        Customer customer;

        Optional<Customer> result = customerRepository.findById(id);

        if (result.isPresent()) {
            customer = result.get();
        } else {

            throw new ResourceNotFoundException("Customer bulunamadı" + id);
        }
        return customer;
    }
}
