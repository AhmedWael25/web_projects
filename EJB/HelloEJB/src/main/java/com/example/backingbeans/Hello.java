package com.example.backingbeans;


import com.example.EJBs.interfaces.HelloBean;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named(value = "user")
@SessionScoped
public class Hello implements Serializable {

    @EJB
    private HelloBean helloBean;


    private  String message ="Tst";
    private  String newMessage ="";

    public HelloBean getHelloBean() {
        return helloBean;
    }

    public void setHelloBean(HelloBean helloBean) {
        this.helloBean = helloBean;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void addHello(){
        String res = helloBean.sayHello();
        this.message = message+ res;
    }


}
