package com.example.backingbeans;


import com.example.EJBs.BookException;
import com.example.EJBs.interfaces.CartOps;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SessionScoped
@Named(value = "cart")
public class Cart implements Serializable {

    private  String bookName;
    private  List<String> books = new ArrayList<>();
    @EJB
    CartOps cartOps;


    @PostConstruct
    public  void init(){
        try {
            books = cartOps.getAllCartItems();
        } catch (BookException e) {
            e.printStackTrace();
        }
    }

    public List<String> getAllBooks() throws BookException {
        return  cartOps.getAllCartItems();
    }

    public void add() throws  BookException{
        books.add(bookName);
        cartOps.addBookToCart(bookName);
    }

    public void remove() throws BookException {
        books.remove(bookName);
        cartOps.removeBookFromCart(bookName);
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }


    public List<String> getBooks() {
        return books;
    }

    public void setBooks(List<String> books) {
        this.books = books;
    }
}
