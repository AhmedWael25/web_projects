package com.playground.test1.service1;

import java.beans.ConstructorProperties;


public class Service1Impl implements Service1Interface  {

    private String name;
    private int age;
    private short shortInt;


    public Service1Impl (){
        System.out.println("Service 1 Const: Service1Impl ()");
    }
    public Service1Impl (int age){
        System.out.println("Service 1 Const: Service1Impl (int age)");
        this.age = age;
    }
    public Service1Impl (short shortInt){
        System.out.println("Service 1 Const: Service1Impl (Short shortInt)");
        this.shortInt = shortInt;
    }
    public Service1Impl (String name){
        System.out.println("Service 1 Const: Service1Impl (String name)");
        this.name = name;
    }
    public Service1Impl (String name, int age){
        System.out.println("Service 1 Const: Service1Impl (String name, int age)");
        this.name = name;
        this.age = age;
    }
    public Service1Impl (int age, String name){
        System.out.println("Service 1 Const: Service1Impl (int age, String name)");
        this.name = name;
        this.age = age;
    }
    @ConstructorProperties({"age", "shortInt"})
    public Service1Impl(int age, short shortInt){
        System.out.println("Service 1 Const: Service1Impl (int age, short shortInt)");
        this.shortInt = shortInt;
        this.age = age;
    }
    @ConstructorProperties({"shortInt", "age"})
    public Service1Impl(short shortInt,int age){
        System.out.println("Service 1 Const: Service1Impl (short shortInt,int age)");
        this.shortInt = shortInt;
        this.age = age;
    }


    public static Service1Interface createServiceImpl(){
        return new Service1Impl();
    }
    public static Service1Interface createServiceImpl(int age, String name){
        return new Service1Impl(age, name);
    }




    @Override
    public void operation1(){
        System.out.println("Service 1 >>> Operation 1");
        System.out.println("Name:"+ name);
        System.out.println("Age" + age);
    }

}
