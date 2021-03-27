package org.playground;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.playground.domain.Account2;
import org.playground.domain.Test;

import java.util.Date;

public class App2 {

    public static void main(String[] args) {

        System.out.println( "Hello World!" );

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

//        Starting Session ============

        Session mySession = sessionFactory.openSession();

        System.out.println("This is my Session" + mySession);

        Account2 myAccount = new Account2();

        myAccount.setUserName("New Annotated");
        myAccount.setAddress("New Addrss");
        myAccount.setBirthday(new Date());
        myAccount.setPassword("123");
        myAccount.setFullName("FullName");
        myAccount.setPhone("011");

        mySession.beginTransaction();
        mySession.persist(myAccount);

        mySession.getTransaction().commit();
        mySession.close();

        System.out.println("InsertionDone --Annotated");


        Test myTest = new Test();
        myTest.setUserName("New Test");
         mySession = sessionFactory.openSession();
        mySession.beginTransaction();
        mySession.persist(myTest);

        mySession.getTransaction().commit();
        mySession.close();

    }
}
