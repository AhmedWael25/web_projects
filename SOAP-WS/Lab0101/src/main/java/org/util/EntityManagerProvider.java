package org.util;


import org.playground.domain.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;


public class EntityManagerProvider {
    


    public static EntityManagerProvider  provider= null;

    EntityManagerFactory emf;
    EntityManager em;

    private EntityManagerProvider(){
        emf = Persistence.createEntityManagerFactory("webservice_JPA");
    }

    public static EntityManagerProvider getInstance(){
        if(provider == null){
            synchronized(EntityManagerProvider.class){
                if(provider == null){
                    provider = new EntityManagerProvider();
                }
            }
        }
        return provider;
    }

public EntityManager getEntityManager(){
    return emf.createEntityManager();
}







}
