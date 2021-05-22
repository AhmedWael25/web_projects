package com.playground.repositories;

import com.playground.domains.Customer;
import com.playground.domains.Order;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository("orderRepository")
@EnableTransactionManagement
public class OrderRepositoryImpl {

    @PersistenceContext(name =" My_JPA_Unit")
    private EntityManager entityManager;


    @Transactional
    public List<Order> getAllOrders(){
        Query q = entityManager.createQuery("from orders");
        List<Order> orders = q.getResultList();
        System.out.println(entityManager.hashCode());
        return orders;
    }

    @Transactional
    public List<Order> getOrdersByCustomerId(int customerId){
        Query q = entityManager.createQuery("from orders o where o.customer.id=:id")
                .setParameter("id", customerId);
        List<Order> orders = q.getResultList();
        System.out.println(entityManager.hashCode());
        return orders;
    }




}
