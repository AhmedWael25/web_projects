package org.playground;



import org.playground.domain.Users;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

public class App
{
    public static void main( String[] args )
    {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("webservice_JPA");
        EntityManager em = emf.createEntityManager();


        Users u = new Users();

        em.getTransaction().begin();

        u.setFirstName("fname");
        u.setSecondName("lname");
        u.setJob("JON");
        u.setDob(new Date());
        em.persist(u);
//        u = em.find(Users.class, 1);


        em.getTransaction().commit();

        System.out.println(u);

        em.close();

    }

}



