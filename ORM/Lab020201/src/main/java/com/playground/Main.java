package com.playground;

import com.playground.generated.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        ServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure().build();
        Metadata metadata = new MetadataSources(standardRegistry).buildMetadata();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();





    }
}
