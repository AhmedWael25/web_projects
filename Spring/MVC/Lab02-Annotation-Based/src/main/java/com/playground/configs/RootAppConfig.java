package com.playground.configs;

import com.playground.services.UserService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("WEB-INF/spring/applicationContext.xml")
// We can also have a component Scan
// @ComponentScan(basePackages = "com.playground.services")
public class RootAppConfig {




    //Test to see if it will be collected in a List of UserSevice.
    @Bean(name = "userService1")
    public UserService userService(){
        return new UserService("I Override object with same bean name");
    }
    @Bean(name = "userService1")
    public UserService userService2(){
        return new UserService();
    }

    //REMEMBER: App context is like a map, so in ANNOTATIONS if we defined a bean
    //with the same name, they will override themselves.

    //testing this ORDERING Mattered.. when with constructor was put first,it init the teststring variable
    //when it was put second it didnit init the string test variable
    //No try to using qualifier in user controller of userService1 it picked the first ON defined(with with constructor)
    //When changing  qualifier to userService2 it gave an err, as expected
    //This tells when bean name match it doesnot fallback to using method name
    
    //it seems that when it overrides id doesnot take the  bean object, but CHECKS THE "MAP"
    //First for an existing bean with that name, if so it doesnot do anything and just ignores it
    //when i used this bean it was overriden with the first one which explains the abbove statemetn

    // XML config is included but is done alst thing, HOWEVER unlike the behavior here it TATALLY
    // override the bean definiion.

    //With component Scanning test printed null, asexpected  It also got createed FIRST then class configs beans
    //if it was the same NAME userService ?
    // IT GOT OVERRIDEN BY the first bean definition we have here


    @Bean(name = "userService1")
    public UserService userService5(){
        return new UserService("I Override object 22e");
    }


    
}
