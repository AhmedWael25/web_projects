package com.playground.repositories;


import com.playground.domain.Customer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
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
public class CustomerRepositoryImpl   {



    private EntityManager entityManager;

    @PersistenceContext(name =" My_JPA_Unit")
    private EntityManager entityManager2;

    TransactionTemplate transactionTemplate;


    @Autowired
    public CustomerRepositoryImpl(@Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory
    ,TransactionTemplate transactionTemplate) {

        System.out.println(">> CustomerRepositoryImpl : Created");

        this.entityManager = entityManagerFactory.createEntityManager();
        this.transactionTemplate = transactionTemplate;

        System.out.println("======CustomerRepositoryImpl Created: ");
        System.out.println("======entityManager 1: Hash =  "+ entityManager.hashCode());
//        System.out.println("======entityManager 2: Hash =  "+ entityManager2.hashCode());
        System.out.println("=======================================");

        System.out.println("//============================ ...TESTING IT'S MTHODS =====================");

    }


    public Customer getCustomerById(int customerId) {
        return entityManager.find(Customer.class, customerId);

    }

    public long getCount() {
        entityManager.getTransaction().begin();
        Query q = entityManager.createQuery("select count(c) from customers c ");

        long count = (Long) q.getSingleResult();
        entityManager.getTransaction().commit();
        return count;
    }

    @Transactional
    public List<Customer> getAllCustomers() {

        String query = "from customers c";

        Query q = entityManager2.createQuery(query);

        List<Customer> customers = q.getResultList();

        return customers;

    }

    @Transactional
    public void updateCustomer(Customer customer) {
        //or use Lovely Merge.
        Customer c = entityManager2.find(Customer.class, customer.getId());
        c.setFirstName(customer.getFirstName());
        c.setLastName(customer.getLastName());
        c.setSalary(customer.getSalary());
    }

    public Customer insertCustomer2(Customer customer) {
        Customer c = transactionTemplate.execute(new TransactionCallback<Customer>() {
            @Override
            public Customer doInTransaction(TransactionStatus status) {
//                Didnot persist
                entityManager.persist(customer);
                return customer;
            }
        });
        return customer;
    }

//    @Transactional
    public Customer insertCustomer3(Customer customer) {
        Customer c = transactionTemplate.execute(new TransactionCallback<Customer>() {
            @Override
            public Customer doInTransaction(TransactionStatus status) {
//                persisted
                entityManager2.persist(customer);
                return customer;
            }
        });
        return customer;
    }

    @Transactional
    public void deleteCustomer(int customerId) {
        Customer cc = entityManager2.find(Customer.class, customerId);
        entityManager2.remove(cc);
    }
}
