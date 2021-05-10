package com.playground.services;


import com.playground.models.Customer;
import com.playground.repositories.CustomerRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customerService")
public class CustomerService {

    @Autowired
    CustomerRepositoryImpl customerRepository;

    public List<Customer> getAllCustomers(){
        return customerRepository.getAllCustomers();
    }

    public  int getCount(){
        return customerRepository.getCount();
    }

    public Customer getCustomer(int customerId) {
        Customer c = customerRepository.getCustomerById(customerId);
        return c;
    }

    public Customer createCustomer(Customer customer){
        Customer insertedCustomer = customerRepository.insertCustomer2(customer);
        return insertedCustomer;
    }

    public Customer updateCustomer(Customer customer) {
        customerRepository.updateCustomer(customer);
        return  customer;
    }

    public void removeCustomer(int customerId) {
        customerRepository.deleteCustomer(customerId);
    }
}
