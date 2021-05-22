package com.playground.services.impls;

import com.playground.services.HelloService;
import org.springframework.stereotype.Service;


@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello() {
        return "Hello From the service";
    }
}
