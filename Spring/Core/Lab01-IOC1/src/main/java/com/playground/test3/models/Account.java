package com.playground.test3.models;


import lombok.*;

@Setter @Getter
public class Account {


    public  Account(){
        System.out.println("Account: Account() =" +this.hashCode());
    }

}
