package com.playground.test2.models;

import lombok.*;

@Setter @Getter
public class User{

    private String name ;
    private Address address;
    User(){
        name = "lol";
        address = new Address();

        System.out.println("Use Created =>"+ this.name + " : "+ this.address);
    }

}