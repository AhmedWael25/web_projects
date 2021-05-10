package com.playground.repositories;


import com.playground.domain.Customer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
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

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("customerRepository")
@EnableTransactionManagement
public class CustomerRepositoryImpl extends HibernateDaoSupport {

    private HibernateTemplate hibernateTemplate;
    private Session session;
    private TransactionTemplate transactionTemplate;

    @Autowired
    public CustomerRepositoryImpl(HibernateTemplate hibernateTemplate,
                                  LocalSessionFactoryBean localSessionFactoryBean ,
                                  TransactionTemplate transactionTemplate) {

        System.out.println(">> CustomerRepositoryImpl(JdbcTemplate jdbcTemplate) : Created");
        this.hibernateTemplate = hibernateTemplate;
        this.session = localSessionFactoryBean.getObject().openSession();
        this.transactionTemplate = transactionTemplate;

        System.out.println("======CustomerRepositoryImpl Created: ");
        System.out.println("======HibernateTemplate : Hash =  "+ hibernateTemplate.hashCode());
        System.out.println("======LocalSessionFactoryBean : Hash =  "+ localSessionFactoryBean.hashCode());
        System.out.println("======Session : Hash =  "+ session.hashCode());
        System.out.println("======TransactionTemplate : Hash =  "+ transactionTemplate.hashCode());
        setSessionFactory(localSessionFactoryBean.getObject());
        System.out.println("HibernateTemplate From DaoSupport Class : HASH  ="+getHibernateTemplate().hashCode());
        System.out.println("=======================================");

        System.out.println("//============================ ...TESTING IT'S MTHODS =====================");

    }


    public Customer getCustomerById(int customerId) {
        return getHibernateTemplate().get(Customer.class, customerId);
    }

    public long getCount() {
        session.beginTransaction();
        Query q = session.createQuery("select count(c) from customers c ");

        long count = (Long) q.uniqueResult();
        session.getTransaction().commit();
        return count;
    }

    public List<Customer> getAllCustomers() {

        String query = "from customers c";

        //Implementation of the HibernateCallback
        List<Customer> customers = getHibernateTemplate().execute(new HibernateCallback<List<Customer>>() {
            @Override
            public List<Customer> doInHibernate(Session session) throws HibernateException {
                session.beginTransaction();
                TypedQuery<Customer> q = session.createQuery(query);
                List<Customer> customers = q.getResultList();
                session.getTransaction().commit();

                return customers;
            }
        });

        return customers;

    }

    @Transactional
    public void updateCustomer(Customer customer) {
        getHibernateTemplate().update(customer);
    }


    //Gave an exception even when
    //Auto commit = true/enalbed
    //InvalidDataAccessApiUsageException: Write operations are not allowed in read-only mode (FlushMode.MANUAL):
    // Turn your Session into FlushMode.COMMIT&#47;AUTO or remove &#39;readOnly&#39; marker from transaction definition.
    public  Customer insertCustomer(Customer customer){
        getHibernateTemplate().saveOrUpdate(customer);
        System.out.println(customer);
        return customer;
    }
    public Customer insertCustomer2(Customer customer) {
        Customer c =getHibernateTemplate().execute(new HibernateCallback<Customer>() {

            @Override
            public Customer doInHibernate(Session session) throws HibernateException {
                session.beginTransaction();
                session.saveOrUpdate(customer);
                session.getTransaction().commit();
                return customer;
            }
        });
        System.out.println(c);
        return customer;
    }

    public Customer insertCustomer3(Customer customer) {
        Customer c =transactionTemplate.execute(new TransactionCallback<Customer>() {
            @Override
            public Customer doInTransaction(TransactionStatus status) {
                getHibernateTemplate().saveOrUpdate(customer);
                return customer;
            }
        });
        return customer;
    }

    public void deleteCustomer(int customerId) {
        getHibernateTemplate().execute(session ->{
            session.beginTransaction();
            Customer c = session.get(Customer.class, customerId);
            System.out.println(c);
            session.delete(c);
            session.flush();//
            session.getTransaction().commit();
            return  null;
        } );
    }
}
