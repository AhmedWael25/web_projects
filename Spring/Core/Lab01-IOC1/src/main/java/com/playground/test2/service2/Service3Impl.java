package com.playground.test2.service2;

import java.beans.ConstructorProperties;
import java.util.List;
import java.util.Map;

import com.playground.test2.daos.productdao.ProductDaoInt;
import com.playground.test2.daos.userdao.UserDaoInt;

import lombok.Setter;
import lombok.Getter;

@Setter @Getter
public class Service3Impl implements Service3Interface{


    List<UserDaoInt> userDaosList;
    
    Map<String, ProductDaoInt> prodDaosMap;

    ProductDaoInt prodDao1;

    Service3Impl(){}


    Service3Impl(ProductDaoInt prod){
        System.out.println("Service 3 : Service3Impl(ProductDaoInt prod)");
        this.prodDao1 = prod;
    }


    @Override
    public void operation1(){
        System.out.println("Service 3 >>> Operation 1");
    }

}