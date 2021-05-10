package com.playground.repositories;


import com.playground.domain.Customer;
import com.playground.repositories.interfaces.CustRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Repository("customerRepository")
@EnableTransactionManagement
public class CustomerRepositoryImpl {


    @Autowired
    private CustRepository custRepository;


    public Customer getCustomerById(int customerId) {
        Optional<Customer> c = custRepository.findById(customerId);

        return c.orElse(null);
    }

    public long getCount() {

        long count = custRepository.count();
        return count;
    }

    @Transactional
    public List<Customer> getAllCustomers() {
//        List<Customer> customers = (List<Customer>) custRepository.findBySalaryGreaterThanEqualOrderBySalaryDesc(6000);
        List<Customer> customers = (List<Customer>) custRepository.findAll();
        return customers;
    }

    @Transactional
    public List<Customer> getAllCustomersPaged(int page, int count) {
        Page<Customer> p =  custRepository.findAll(PageRequest.of(page,count));

        return p.getContent();
    }



    @Transactional
    public void updateCustomer(Customer customer) {

        //We can update using save as well
        custRepository.save(customer);

    }

    @Transactional
    public Customer insertCustomer2(Customer customer) {
        Customer c = custRepository.save(customer);
        return  c;
    }


    @Transactional
    public void deleteCustomer(int customerId) {
        custRepository.deleteById(customerId);
    }
}
