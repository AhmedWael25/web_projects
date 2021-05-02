package com.playground.configs;

import com.playground.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
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
@Import(InternationalizationConfig.class)
public class WebAppConfig implements WebMvcConfigurer{


    @Autowired
    private InternationalizationConfig internationalizationConfig;

    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver iResolver = new InternalResourceViewResolver("/WEB-INF/pages/", ".jsp");
        iResolver.setOrder(10);
        return iResolver;
    }

    @Bean
    public CommonsMultipartResolver multipartResolver(){
        return new CommonsMultipartResolver();
    }

    // ================================= CONFIGS ===================================== 
    //We registerd our interceptor in the registry
    // Interceptor vs filter?
    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry){
       interceptorRegistry.addInterceptor(internationalizationConfig.localeChangeInterceptor()).addPathPatterns("/*.htm");
       interceptorRegistry.addInterceptor(new MyHandlerInterceptor()).addPathPatterns("/*.htm");
    }

    //To use a ParameterizableViewController, that serves static resource
    //useful when ther's no need for controller with logic
    //if using XML <mvc:view-controller path="/" view-name="home"/>
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/static.htm").setViewName("staticPage");
    }

    
}
