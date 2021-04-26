package com.playground.test4;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Set;

@Setter @Getter @ToString
@Component
// @Lazy redundant if prototype
// @Scope("prototype")
public class ChildRepo {
    private String name;
    private int age;
    private String address;

    List myList;
    Set mySet;


    public ChildRepo(){
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