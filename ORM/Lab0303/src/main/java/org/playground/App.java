package org.playground;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.playground.inheritance3.Person;
import org.playground.inheritance3.Student;
import org.playground.inheritance3.Teacher;

import java.util.Date;

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

        Person person3 = new Person();
        person3.setFirstName("person3");
        person3.setLastName("person3");


        Student student3 = new  Student();
        student3.setFirstName("stud3");
        student3.setLastName("stud3");
        student3.setDepartment("Department 3");


        Teacher teacher3 = new Teacher();
        teacher3.setFirstName("teacher3");
        teacher3.setLastName("teacher3");
        teacher3.setHireDate(new Date());

        Session mySession = sessionFactory.openSession();

        mySession.beginTransaction();

        mySession.persist(person3);
        mySession.persist(student3);
        mySession.persist(teacher3);

        mySession.getTransaction().commit();

        mySession.close();

    }
}
