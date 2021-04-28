package com.playground.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("WEB-INF/spring/applicationContext.xml")
public class RootAppConfig {
    
}
