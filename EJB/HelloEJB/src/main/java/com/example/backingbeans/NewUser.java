package com.example.backingbeans;

import com.example.EJBs.BookException;
import com.example.EJBs.interfaces.CartOps;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@SessionScoped
@Named(value = "newuser")
public class NewUser implements Serializable {


    private String userId;
    private  String userName;

    @EJB
    CartOps cartOps;

    public String createCustomer() throws BookException {
        cartOps.initUser("10",userName);
        return "cart";
    }






    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
