package com.playground.services;


import com.playground.domain.Customer;
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
    private Session session;

    @Autowired
    public CustomerService(CustomerRepositoryImpl customerRepository, LocalSessionFactoryBean localSessionFactoryBean) {
        this.customerRepository = customerRepository;
        session = localSessionFactoryBean.getObject().openSession();
        System.out.println("======customerService Created: ");
        System.out.println("======LocalSessionFactoryBean : Hash =  "+ localSessionFactoryBean.hashCode());
        System.out.println("======Session : Hash =  "+ session.hashCode());
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
//        Customer insertedCustomer = customerRepository.insertCustomer(customer);
//        Customer insertedCustomer = customerRepository.insertCustomer2(customer);
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
