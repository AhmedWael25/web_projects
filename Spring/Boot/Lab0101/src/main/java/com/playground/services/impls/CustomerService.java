package com.playground.services.impls;


import com.playground.domains.Customer;
import com.playground.repositories.CustomerRepositoryImpl;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("customerService")
public class CustomerService {


    private  CustomerRepositoryImpl customerRepository;

    @Autowired
    public CustomerService(CustomerRepositoryImpl customerRepository) {
        this.customerRepository = customerRepository;
        System.out.println("======customerService Created: ");
        System.out.println("=======================================");
    }

    public List<Customer> getAllCustomers(){
        return customerRepository.getAllCustomers();
    }

    public  long getCount(){
        return customerRepository.getCount();
    }

    public Customer getCustomer(int customerId) {
        Customer c = customerRepository.getCustomerById(customerId);
        return c;
    }

    public Customer createCustomer(Customer customer){
        Customer insertedCustomer = customerRepository.insertCustomer3(customer);
        return insertedCustomer;
    }

    @Transactional
    public Customer updateCustomer(Customer customer) {
        customerRepository.updateCustomer(customer);
        return  customer;
    }

    public void removeCustomer(int customerId) {
        customerRepository.deleteCustomer(customerId);
    }
}
