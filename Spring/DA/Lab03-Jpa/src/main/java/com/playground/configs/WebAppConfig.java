package com.playground.configs;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ImportResource("WEB-INF/spring/mvc.xml")
@Import({InternationalizationConfig.class})
public class WebAppConfig implements WebMvcConfigurer{


    @Autowired
    private InternationalizationConfig internationalizationConfig;


    //===================== View Configs =========================

    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver iResolver = new InternalResourceViewResolver("/WEB-INF/pages/", ".jsp");
        iResolver.setOrder(10);
        return iResolver;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/test").setViewName("testPage");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
    }
}
