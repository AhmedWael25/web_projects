package com.example.EJBs.impl;

import com.example.EJBs.BookException;
import com.example.EJBs.interfaces.CartOps;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Remove;
import jakarta.ejb.Stateful;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@Stateful
public class CartBean implements CartOps {

    private String id;
    private String name;
    private List<String> books;


//    @PersistenceContext(unitName = "myUnit")
//    EntityManager entityManager;



    @PostConstruct
    public void init(){
        books = new ArrayList<>();
        books.add("TST");
    }

    @Override
    public void initUser(String userId, String userName) throws BookException {
        if(userId == null || userName == null){
            throw  new BookException("Invalid User");
        }else {
            id = userId;
            name = userName;

        }
    }

    @Override
    public void addBookToCart(String bookTitle) throws BookException {
        if(bookTitle == null){
            throw new BookException("Invalid Book");
        }
        books.add(bookTitle);
    }

    @Override
    public void removeBookFromCart(String bookTitle) throws BookException {
        if(bookTitle == null){
            throw new BookException("Invalid Book");
        }
       boolean result =  books.removeIf(s -> s.equals(bookTitle));
        if(!result){
            throw new BookException("Doesnot xist");
        }
    }

    @Override
    public List<String> getAllCartItems() {
        return books;
    }

    @Override
    @Remove
    public void removeCart() {
        books.clear(); books = null;
    }
}
