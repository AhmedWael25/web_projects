package com.playground.test3.models;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.*;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.*;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;
import javax.annotation.*;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;

@Setter @Getter @ToString
@Component
@Named("parent1")
@Scope("singleton")
public class Parent{

    @Value("Def Value From Anno.")
    private String name;
    private int age;

    //On-demand access, if Child doesnot exist on access => error
    private Provider<Child> child;

    public Parent(){
        System.out.println("Parent Bean: Parent()");
    }

    @Inject
    public Parent(Provider<Child> c){
        System.out.println("Parent Bean: Parent(Provider<Child> c)");
        this.child = c;
    }


//    @Inject
//    public Parent(Child child){
//        System.out.println("Parent : Parent(Child child)");
//    }
//    @Inject
//    public void setChild(Child c){
//
//    }

    public  Child getMyChild(){
        return  child.get();
    }

    @PostConstruct
    public void init(){
        System.out.println("Parent Init()");
    }
    @PreDestroy
    public  void close(){
        System.out.println("Parent close()");
    }

}