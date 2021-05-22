package com.playground.configs;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan(basePackages = {"com.playground.services","com.playground.repositories"})
@Import({JPAConfig.class})
@EnableAutoConfiguration
public class RootAppConfig {


    
}
