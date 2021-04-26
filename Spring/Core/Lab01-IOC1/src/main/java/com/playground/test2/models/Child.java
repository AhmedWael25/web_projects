package com.playground.test2.models;

import java.util.List;
import java.util.Set;

import lombok.*;

@Setter @Getter @ToString
public class Child{
    private String name;
    private int age;
    private String address;

    List myList;
    Set mySet;


    public Child(){
        System.out.println("Child Bean: Child()");
    }


    public void printList(){
        System.out.println(myList);
    }
    public void printSet(){
        System.out.println(mySet);
    }

}