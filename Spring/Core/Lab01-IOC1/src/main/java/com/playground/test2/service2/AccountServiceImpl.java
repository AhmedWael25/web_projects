package com.playground.test2.service2;

import com.playground.test2.daos.productdao.ProductDaoInt;
import com.playground.test2.models.Child;
import com.playground.test2.models.Parent;

import lombok.*;
import org.springframework.context.*;
import org.springframework.context.support.*;
import org.springframework.beans.factory.annotation.*;
import javax.annotation.*;

@ToString
public class AccountServiceImpl{

    private ProductDaoInt productDao;
    private Parent parent;

    
    AccountServiceImpl(){
        System.out.println("Acc Service : AccountServiceImpl()");
    }

    @Autowired
    //The annotaiton can be removed if we have ONLY one constructor like this
    //and it will automatically autowire
    AccountServiceImpl(Parent parent){
        System.out.println("Acc Service : AccountServiceImpl(Parent parent)");
        this.parent = parent;
    }

    @Required
    public void setParent(Parent parent){
        this.parent = parent;
        System.out.println("Acc ServicdfdsfdsfeImpl()");

    }

    // @Autowired
    //bOTH MUST BE PROVIDED as definitons in XML file
    public void setup( ProductDaoInt productDao, Parent parent){
        this.parent = parent;
        this.productDao = productDao;
    }

    public void setProductDao(ProductDaoInt prodDao){
        this.productDao = prodDao;
        System.out.println("Acc ServicdfdsfdsfeImpl()");
    }


}
