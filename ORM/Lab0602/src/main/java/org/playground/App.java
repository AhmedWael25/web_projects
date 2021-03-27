package org.playground;


import org.playground.domain.Author;

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

        Author author = new Author("Name", new Date());
        author.setAge(25);
//        author.setAge(150);


        em.getTransaction().begin();

        em.persist(author);

        em.getTransaction().commit();

        em.close();
        emf.close();

    }

}



