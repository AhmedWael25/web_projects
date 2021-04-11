package com.playground.beans;


import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;

//@SessionScoped
//@ManagedBean(value = "user")
//@Named(value = "user")
public class LoginBean  implements Serializable {


    private String name;
    private String pw;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String verify(){
        if( name.equals("ahmed") && pw.equals("123") ){
            return  "success";
        }else {
            return "failure";
        }
    }




}
