package com.playground.test3;


import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.*;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;
import javax.annotation.*;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;


@Configuration
@Import({AppConfig2.class, AppConfig3.class})
@ComponentScan(basePackages = "com.playground.test3")
public class AppConfig1 {

    public AppConfig1() {
        System.out.println("AppConfig1 @Configuraiton: AppConfig1()");
    }

}
