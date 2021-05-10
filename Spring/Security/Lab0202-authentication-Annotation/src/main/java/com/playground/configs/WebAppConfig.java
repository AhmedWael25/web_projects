package com.playground.configs;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ImportResource("WEB-INF/spring/mvc.xml")
@ComponentScan({"com.playground.controllers"})
public class WebAppConfig implements WebMvcConfigurer{


    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver iResolver = new InternalResourceViewResolver("/WEB-INF/pages/", ".jsp");
        iResolver.setOrder(10);
        return iResolver;
    }


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/test").setViewName("testPage");
        registry.addViewController("/error").setViewName("errorPage");
    }
}
