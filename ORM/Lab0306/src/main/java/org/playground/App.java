package org.playground;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.playground.inheritance1.Person;
import org.playground.inheritance1.Student;
import org.playground.inheritance1.Teacher;

import java.awt.dnd.DropTarget;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();


        Person p = new Person();
        p.setLastName("person1 LN");
        p.setFirstName("person1 FN");



        Session session1 = sessionFactory.openSession();
        Session session2 = sessionFactory.openSession();

        session1.beginTransaction();
        session2.beginTransaction();

        Person user1 = session1.find(Person.class, 1);

        session1.getTransaction().commit();

        Person user11 = session2.find(Person.class, 1);

        session2.getTransaction().commit();

        System.out.println("First User: " + user1);

        System.out.println("Same User: " + user11);

//        ===========================   ONLY 1 SELECT STATEMENT WAS ISSUED ========================

//        session1.getTransaction().commit();
//        session2.getTransaction().commit();


        session1.close();
        session2.close();
        sessionFactory.close();
    }
}
