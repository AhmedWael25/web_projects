package com.playground.repositories;


import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionTemplate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

@Repository
public class OrderRepositoryImpl   {

    private EntityManager entityManager;

    @PersistenceContext(name =" My_JPA_Unit")
    private EntityManager entityManager2;


    @Autowired
    public OrderRepositoryImpl(@Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {

        System.out.println(">> CustomerRepositoryImpl : Created");

        this.entityManager = entityManagerFactory.createEntityManager();

        System.out.println("======CustomerRepositoryImpl Created: ");
        System.out.println("======entityManager 1: Hash =  "+ entityManager.hashCode());
//        System.out.println("======entityManager 2: Hash =  "+ entityManager2.hashCode());
        System.out.println("=======================================");

        System.out.println("//============================ ...TESTING IT'S MTHODS =====================");

    }
}
