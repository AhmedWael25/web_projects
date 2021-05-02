package com.playground.services;

import com.playground.models.*;

import java.util.*;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


@Service(value = "userService1")
public class UserService{

    List<User> users = new ArrayList<>();

    private String test;


    public UserService(){
        System.out.println("Service Bean Has ben created==="+ test);
        System.out.println("My Hash Code  = " + this.hashCode());
        for(int i = 1 ; i <= 10; i++){
            User u = new User("fname_"+i, "lname_"+i, 1500);
            users.add(u);
        }
    }

    public UserService(String test){
        this.test = test;
        System.out.println("Service Bean Has ben created=== TEST: "+ test);
        System.out.println("My Hash Code  = " + this.hashCode());
        for(int i = 1 ; i <= 10; i++){
            User u = new User("fname_"+i, "lname_"+i, 1500);
            users.add(u);
        }
    }

    public List<User> getAllUsers(){
        return users;
    }

    public List<User> getRandomUser(){
        int number = new Random().nextInt(10);
        List<User> u = new ArrayList<User>();
        u.add(users.get(number));
        return u;
    }

    public void addUser(User user){
        users.add(user);
    }


}