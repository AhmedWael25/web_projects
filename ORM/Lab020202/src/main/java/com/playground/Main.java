package com.playground;

import com.playground.dao.*;

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


        //Steps To Create User
        Category cat1 = new Category();
        cat1.setValue("PS4");
        cat1.setDescription("Awesome Desc. Again");

        Category cat2 = new Category();
        cat2.setValue("Games");
        cat2.setDescription("YET ANOTHER AWEOMSE DESC.");

        User sellerUser = new User();
        sellerUser.setAddress("Adddress SELLER");
        sellerUser.setEmail("Emailk SELLER");
        sellerUser.setDateOfBirth(new Date());
        sellerUser.setFullName("Name SELLER");
        sellerUser.setUserName("USERNAME SELLER");
        sellerUser.setPassword("123 SELLER");
        sellerUser.setRegistrationDate(new Date());

        User buyerUser = new User();
        buyerUser.setAddress("Adddress BUYER");
        buyerUser.setEmail("Emailk BUYER");
        buyerUser.setDateOfBirth(new Date());
        buyerUser.setFullName("Name BUYER");
        buyerUser.setUserName("BUYER");
        buyerUser.setPassword("123 BUYER");
        buyerUser.setRegistrationDate(new Date());

        Seller mySeller = new Seller();
        mySeller.setValue("Awesome Seller");
        mySeller.setUser(sellerUser);

        Buyer myBuyer = new Buyer();
        myBuyer.setValue("Awesomse Buyer");
        myBuyer.setUser(buyerUser);


        Product myProduct = new Product();
        myProduct.setQuantity(100);
        myProduct.setSeller(mySeller);
        myProduct.setOfferedDate(new Date());
        myProduct.setDescription("Awesome Desription");
        myProduct.setFinishDate(new Date());
        myProduct.setName("PRODUCT NAME");
        myProduct.setManufacturingName("PS");
        myProduct.setManufacturingDate(new Date());


        Session mySession = sessionFactory.openSession();

        mySession.beginTransaction();

        mySession.persist(cat1);
        mySession.persist(cat2);
        mySession.persist(sellerUser);
        mySession.persist(buyerUser);
        mySession.persist(mySeller);
        mySession.persist(myBuyer);
        mySession.persist(myProduct);


        mySession.getTransaction().commit();


        BuyerBuyProductId buyerBuyProductId = new BuyerBuyProductId();
        buyerBuyProductId.setBuyerId(myBuyer.getId());
        buyerBuyProductId.setProductId(myProduct.getId());


        BuyerBuyProduct buyerBuyProduct = new BuyerBuyProduct();
        buyerBuyProduct.setProduct(myProduct);
        buyerBuyProduct.setBuyer(myBuyer);
        buyerBuyProduct.setQuantity(10);
        buyerBuyProduct.setPaymentDate(new Date());
        buyerBuyProduct.setId(buyerBuyProductId);


        mySession.persist(buyerBuyProduct);


        mySession.beginTransaction();
        Set<Category> cats = new HashSet();
        cats.add(cat1);
        cats.add(cat2);
        myProduct.setCategories(cats);


        mySession.getTransaction().commit();

        System.out.println("InsertionDone");
        mySession.close();

    }
}
