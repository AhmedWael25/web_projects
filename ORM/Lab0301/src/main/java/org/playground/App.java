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

        Person person1 = new  Person();
        person1.setFirstName("person1");
        person1.setLastName("person1");

        Student student1 = new  Student();
        student1.setFirstName("stud1");
        student1.setLastName("stud1");
        student1.setDepartment("dEP1" );

        Teacher teacher1 = new Teacher();
        teacher1.setFirstName("teadh1");
        teacher1.setLastName("teadh1");
        teacher1.setHireDate(new Date());


        Session mySession = sessionFactory.openSession();

        mySession.beginTransaction();

        mySession.persist(person1);
        mySession.persist(student1);
        mySession.persist(teacher1);


        mySession.getTransaction().commit();

        mySession.close();

    }
}
