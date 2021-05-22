package com.playground.repositories;


import com.playground.domains.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import javax.persistence.*;
import java.util.List;

@Repository("customerRepository")
@EnableTransactionManagement
public class CustomerRepositoryImpl {


    @PersistenceContext(name =" My_JPA_Unit")
    private EntityManager entityManager;


    public Customer getCustomerById(int customerId) {
        return entityManager.find(Customer.class, customerId);
    }


    public long getCount() {
        Query q = entityManager.createQuery("select count(c) from customers c ");

        long count = (Long) q.getSingleResult();
        return count;
    }

    public List<Customer> getAllCustomers() {

        String query = "from customers c";

        Query q = entityManager.createQuery(query);

        List<Customer> customers = q.getResultList();

        System.out.println(entityManager.hashCode());

        return customers;

    }

    public void updateCustomer(Customer customer) {
        //or use Lovely Merge.
        Customer c = entityManager.find(Customer.class, customer.getId());
        c.setFirstName(customer.getFirstName());
        c.setLastName(customer.getLastName());
        c.setSalary(customer.getSalary());
    }



    public Customer insertCustomer3(Customer customer) {
        entityManager.persist(customer);
        System.out.println(customer);
        return  customer;
    }

    public void deleteCustomer(int customerId) {
        Customer cc = entityManager.find(Customer.class, customerId);
        entityManager.remove(cc);
    }
}
