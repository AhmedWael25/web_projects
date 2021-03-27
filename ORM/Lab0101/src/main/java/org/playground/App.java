package org.playground;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.playground.domain.Account;

import javax.security.auth.login.Configuration;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

//        Starting Session ============

        Session mySession = sessionFactory.openSession();

        System.out.println("This is my Session" + mySession);

        Account myAccount = new Account();

        myAccount.setUserName("New Username");
        myAccount.setAddress("New Addrss");
        myAccount.setBirthday(new Date());
        myAccount.setPassword("123");
        myAccount.setFullName("FullName");
        myAccount.setPhone("011");

        mySession.beginTransaction();
        mySession.persist(myAccount);

        mySession.getTransaction().commit();

        System.out.println("InsertionDone");

    }
}
