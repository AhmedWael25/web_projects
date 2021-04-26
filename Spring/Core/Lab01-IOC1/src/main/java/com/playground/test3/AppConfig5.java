package com.playground.test3;


import com.playground.test3.services.TestService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
@ProductionProfile
//@Profile("unwantedProfile")
public class AppConfig5 {

    @Bean
    public TestService testService2(){
        System.out.println("TestService from Production Profile");
        return  new TestService();
    }


}
