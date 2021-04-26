package com.playground.test3.models;

import java.util.List;
import java.util.Set;

import lombok.*;
import org.springframework.context.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Component;

import javax.annotation.*;

@Setter @Getter @ToString
@Component
@Lazy
//@Scope("prototype")
public class Child{
    private String name;
    private int age;
    private String address;

    List myList;
    Set mySet;


    public Child(){
        System.out.println("Child Bean: Child() =" + this.hashCode());
    }

    @PostConstruct
    public  void init(){
        System.out.println("Child: init()");
    }
    public void close(){
        System.out.println("Child: close()");
    }

    public void printList(){
        System.out.println(myList);
    }
    public void printSet(){
        System.out.println(mySet);
    }

}