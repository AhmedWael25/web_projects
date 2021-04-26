package com.example.backingbeans;


import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named(value = "JSMMessageModel")
@RequestScoped
public class JSMMessageModel {

    private String myMsg;

    public String getMyMsg() {
        return myMsg;
    }

    public void setMyMsg(String myMsg) {
        this.myMsg = myMsg;
    }

}


