package com.playground.test3;


import com.playground.test3.models.Account;
import com.playground.test3.models.Child;
import com.playground.test3.repositories.AccountDaoImpl;
import org.springframework.context.annotation.*;


@Configuration
//@Import(AppConfig3.class) //Both are imported in AppConfig1 so this is redundant
public class AppConfig2 {
    public AppConfig2() {
        System.out.println("AppConfig2 @Configuraiton: AppConfig2()");
    }

    //Having Child as a component and as a bean def. created 2 instances.
    //The Child Bean had @Postcontruct and init called once
    //When we explicitly used init inside bean it called it twice
    //the explicit init() call was called first
    @Bean(initMethod = "init", destroyMethod = "close")
//    @Scope("singleton")
//    @Lazy
    public Child myChild(){
        Child c = new Child();
        System.out.print("Init from inside the Bean definition using @Bean, ");
        c.init();
        System.out.println("After Init  using @Bean, ");
        return  c;
    }

    //This only uses the bean definiition from AppConfig 3
    @Bean
//    @Scope("prototype") //Called 2 times when prototype
    public Account myAccount1(){
        System.out.println("Creating Account() from App Config 2");
        return new Account();
    }
    //These methods will be called 2 times, however they will share a single instance of Account
    //because all classes 2ith @configuraiton are sub-classed with CGLIB
    //Methods will check the container first for any cached instances
    //if not create, if yes use existing instance
    @Bean
    public AccountDaoImpl accountDao1(){
        System.out.println("Entered accountDao1() from Config2");
        return  new AccountDaoImpl(myAccount1());
    }
    @Bean
    public AccountDaoImpl accountDao2(){
        System.out.println("Entered accountDao2() From Config2");
        return  new AccountDaoImpl(myAccount1());
    }
    
}
