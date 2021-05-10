package com.playground.configs;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ImportResource("WEB-INF/spring/applicationContext.xml")
// We can also have a component Scan
// @ComponentScan(basePackages = "com.playground.services")
public class RootAppConfig {

    @Bean("mySqlDataSource")
    public DataSource dataSource(){
        System.out.println(">>> Data Source Created");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring_da");
        dataSource.setUsername("root");
        dataSource.setPassword("admin");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return  dataSource;
    }


}
