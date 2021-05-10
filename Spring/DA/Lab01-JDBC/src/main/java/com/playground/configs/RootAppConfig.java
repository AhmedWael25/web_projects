package com.playground.configs;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("WEB-INF/spring/applicationContext.xml")
// We can also have a component Scan
@ComponentScan(basePackages = {"com.playground.services","com.playground.repositories"})
@Import(JDBCConfig.class)
public class RootAppConfig {


    
}
