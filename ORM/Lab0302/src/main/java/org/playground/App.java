package org.playground;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.playground.inheritance2.Person;
import org.playground.inheritance2.Student;


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

        Person person2 = new Person();
        person2.setFirstName("person2");
        person2.setLastName("person2");


        Student student2 = new  Student();
        student2.setFirstName("stud2");
        student2.setLastName("stud2");
        student2.setDepartment("Department 2");


        Session mySession = sessionFactory.openSession();

        mySession.beginTransaction();

        mySession.persist(person2);
        mySession.persist(student2);

        mySession.getTransaction().commit();

        mySession.close();

    }
}
