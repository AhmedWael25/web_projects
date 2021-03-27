package org.playground;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.playground.domain.Category;
import org.playground.domain.User;

import java.util.Date;


public class App
{
    public static void main( String[] args )
    {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        Session session = sessionFactory.withOptions().interceptor(new SessionInterceptor()).openSession();

        //
        //
        //
        //
        
//
//        Category cat = new Category();
//        cat.setValue("new Cat");
//        cat.setDescription("DESC");
//
//        session.persist(cat);
//
//        Category cat2 = session.find(Category.class, 33);
//
//        System.out.println(cat2);

//
//        cat2.setValue("UPDATED CAT");
//


//        User u = session.find(User.class, 24);


        session.beginTransaction();


        User u = new User();
        u.setUserName("sisy");
        u.setAddress("sisy");
        u.setEmail("ssy");
        u.setPassword("sisy");
        u.setFullName("aksjas");
        u.setRegistrationDate(new Date());


        System.out.println("as"+u.hashCode());

        session.save(u);

        System.out.println("as"+u.hashCode());
        //Delegating interceptor to super method, Gave
        //



        System.out.println(u);
        session.getTransaction().commit();





//
//        Session session1 = sessionFactory.openSession();
//        Session session2 = sessionFactory.openSession();
//
//
//        User u = session1.find()
//


    }

}



