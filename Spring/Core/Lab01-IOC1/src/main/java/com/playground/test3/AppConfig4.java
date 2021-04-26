package com.playground.test3;


import com.playground.test3.models.Account;
import com.playground.test3.repositories.AccountDaoImpl;
import com.playground.test3.services.AccountService;
import com.playground.test3.services.AccountServiceImpl;
import com.playground.test3.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;


@Configuration
//@ProductionProfile
@Profile("unwantedProfile")
public class AppConfig4 {

    @Bean
    public TestService testService2(){
        System.out.println("TestService from Un Wanted Profile");
        return  new TestService();
    }


}
