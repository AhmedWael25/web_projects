package com.example.EJBs.interfaces;

import com.example.EJBs.BookException;
import jakarta.ejb.Remote;

import java.util.List;

@Remote
public interface CartOps {
     void initUser(String userId, String userName) throws BookException;

     void addBookToCart(String bookTitle) throws BookException;

     void removeBookFromCart(String bookTitle) throws BookException;

     List<String> getAllCartItems() throws  BookException;

     void removeCart();
}
