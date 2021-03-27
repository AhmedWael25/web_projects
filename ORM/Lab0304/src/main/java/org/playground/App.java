package org.playground;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.playground.inheritance4.Person;
import org.playground.inheritance4.Student;
import org.playground.inheritance4.Teacher;

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

        Person person4 = new Person();
        person4.setFirstName("person4");
        person4.setLastName("person4");


        Student student4 = new  Student();
        student4.setFirstName("student4");
        student4.setLastName("student4");
        student4.setDepartment("Department 4");


        Teacher teacher4 = new Teacher();
        teacher4.setFirstName("teacher4");
        teacher4.setLastName("teacher4");
        teacher4.setHireDate(new Date());

        Session mySession = sessionFactory.openSession();

        mySession.beginTransaction();

        mySession.persist(person4);
        mySession.persist(student4);
        mySession.persist(teacher4);

        mySession.getTransaction().commit();

        mySession.close();

    }
}
