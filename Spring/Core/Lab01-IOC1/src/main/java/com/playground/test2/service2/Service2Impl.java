package com.playground.test2.service2;

import java.beans.ConstructorProperties;

import com.playground.test2.daos.productdao.ProductDaoInt;
import com.playground.test2.daos.userdao.UserDaoInt;

import lombok.Setter;
import lombok.Getter;

@Setter @Getter
public class Service2Impl implements Service2Interface{

    
    private String name;
    private int age;
    private short shortInt;

    //This needs 2 Daos to work
    ProductDaoInt productDao;
    UserDaoInt userDao;



    public Service2Impl (){
        System.out.println("Service 2 Const: Service2Impl ()");
    }
    public Service2Impl (int age){
        System.out.println("Service 2 Const: Service2Impl (int age)");
        this.age = age;
    }
    public Service2Impl (short shortInt){
        System.out.println("Service 2 Const: Service2Impl (Short shortInt)");
        this.shortInt = shortInt;
    }
    public Service2Impl (String name){
        System.out.println("Service 2 Const: Service2Impl (String name)");
        this.name = name;
    }
    public Service2Impl (String name, int age){
        System.out.println("Service 2 Const: Service2Impl (String name, int age)");
        this.name = name;
        this.age = age;
    }
    public Service2Impl (int age, String name){
        System.out.println("Service 2 Const: Service2Impl (int age, String name)");
        this.name = name;
        this.age = age;
    }
    @ConstructorProperties({"age", "shortInt"})
    public Service2Impl(int age, short shortInt){
        System.out.println("Service 2 Const: Service2Impl (int age, short shortInt)");
        this.shortInt = shortInt;
        this.age = age;
    }
    @ConstructorProperties({"shortInt", "age"})
    public Service2Impl(short shortInt,int age){
        System.out.println("Service 2 Const: Service2Impl (short shortInt,int age)");
        this.shortInt = shortInt;
        this.age = age;
    }
    public Service2Impl(ProductDaoInt productDao,UserDaoInt userDao){
        System.out.println("Service 2 Const: Service2Impl (ProductDaoInt productDao,UserDaoInt userDao):"+this.hashCode());
        this.productDao = productDao;
        this.userDao = userDao;
    }
    // public Service2Impl(UserDaoInt userDao,ProductDaoInt productDao){
    //     System.out.println("Service 2 Const: Service2Impl (UserDaoInt userDao,ProductDaoInt productDao):"+this.hashCode());
    //     this.productDao = productDao;
    //     this.userDao = userDao;
    // }


    @Override
    public void operation1(){
        System.out.println("Service 2 >>> Operation 1");
        System.out.println("Name:"+ name);
        System.out.println("Age" + age);
    }


}