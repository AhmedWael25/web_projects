package com.playground.configs;


import org.springframework.context.annotation.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;

@Configuration
@ImportResource("WEB-INF/spring/applicationContext.xml")
// We can also have a component Scan
@ComponentScan(basePackages = {"com.playground.services","com.playground.repositories"} )
@Import(PersistenceJPAConfig.class)
public class RootAppConfig {


    
}
