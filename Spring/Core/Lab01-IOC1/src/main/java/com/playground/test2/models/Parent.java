package com.playground.test2.models;

import lombok.*;

@Setter @Getter @ToString
public class Parent{

    private String name;
    private int age;

    public Parent(){
        System.out.println("Parent Bean: Parent()");
    }

}