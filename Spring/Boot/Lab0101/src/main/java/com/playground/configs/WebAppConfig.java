package com.playground.configs;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
//@EnableWebMvc
//@Import({InternationalizationConfig.class})
@EnableAutoConfiguration
//If removed
//Unable to start ServletWebServerApplicationContext due to missing ServletWebServerFactory bean
@ComponentScan({"com.playground.controllers"})
public class WebAppConfig implements WebMvcConfigurer{


    //===================== View Configs =========================

//    @Bean
//    public ViewResolver viewResolver(){
//        InternalResourceViewResolver iResolver = new InternalResourceViewResolver("/WEB-INF/pages/", ".jsp");
//        iResolver.setOrder(10);
//        return iResolver;
//    }

//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/test").setViewName("testPage");
//    }

//    @Override
//    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//        configurer.enable();
//    }

}
