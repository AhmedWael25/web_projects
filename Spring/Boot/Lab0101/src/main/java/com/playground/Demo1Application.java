package com.playground;

import com.playground.configs.JPAConfig;
import com.playground.configs.RootAppConfig;
import com.playground.configs.WebAppConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


//
@SpringBootApplication
//@SpringBootApplication(exclude ={JPAConfig.class, RootAppConfig.class, WebAppConfig.class})
//extends SpringBootServletInitializer
public class Demo1Application {


    public static void main(String[] args) {

//        SpringApplication.run(Demo1Application.class, args);

        SpringApplicationBuilder parentBuilder = new SpringApplicationBuilder(RootAppConfig.class)
                        .web(WebApplicationType.NONE);
        parentBuilder.run(args);

        parentBuilder.child(WebAppConfig.class).web(WebApplicationType.SERVLET).run(args);


    }


}
