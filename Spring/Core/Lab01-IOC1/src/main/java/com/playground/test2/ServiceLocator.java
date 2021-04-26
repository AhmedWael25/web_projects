package com.playground.test2;

import com.playground.test2.daos.productdao.*;
import com.playground.test2.daos.userdao.*;
import com.playground.test2.service2.*;

public class ServiceLocator{

    ServiceLocator(){}


    public Service2Interface createService2Instance(ProductDaoInt pr, UserDaoInt us){
        return new Service2Impl(pr,us);
    }
    
}