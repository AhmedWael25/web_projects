package com.playground.repositories;


import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionTemplate;

@Repository
public class OrderRepositoryImpl   extends HibernateDaoSupport {

    private HibernateTemplate hibernateTemplate;
    private Session session;
    private TransactionTemplate transactionTemplate;

    @Autowired
    public OrderRepositoryImpl(HibernateTemplate hibernateTemplate,
                               LocalSessionFactoryBean localSessionFactoryBean ,
                               TransactionTemplate transactionTemplate) {

        System.out.println(">> OrderRepositoryImpl(JdbcTemplate jdbcTemplate) : Created");
        this.hibernateTemplate = hibernateTemplate;
        this.session = localSessionFactoryBean.getObject().openSession();
        this.transactionTemplate = transactionTemplate;

        System.out.println("======OrderRepositoryImpl Created: ");
        System.out.println("======HibernateTemplate : Hash =  "+ hibernateTemplate.hashCode());
        System.out.println("======LocalSessionFactoryBean : Hash =  "+ localSessionFactoryBean.hashCode());
        System.out.println("======Session : Hash =  "+ session.hashCode());
        System.out.println("======TransactionTemplate : Hash =  "+ transactionTemplate.hashCode());
        setSessionFactory(localSessionFactoryBean.getObject());
        System.out.println("HibernateTemplate From DaoSupport Class : HASH  ="+getHibernateTemplate().hashCode());
        System.out.println("=======================================");

    }
}
