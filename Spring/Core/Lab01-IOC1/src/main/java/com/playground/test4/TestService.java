package com.playground.test4;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
@Service(value = "testServiceBean1")
public class TestService {


    public TestService(){
        System.out.println("TestService: TestService()");
    }
}
