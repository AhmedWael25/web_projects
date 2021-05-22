package com.playground.repositories;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository("productRepository")
@EnableTransactionManagement
public class ProductRepositoryImpl {

    @PersistenceContext(name =" My_JPA_Unit")
    private EntityManager entityManager;




}
