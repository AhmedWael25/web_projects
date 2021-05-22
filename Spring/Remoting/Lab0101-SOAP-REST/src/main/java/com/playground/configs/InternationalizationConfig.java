package com.playground.configs;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

//@Configuration
public class InternationalizationConfig implements WebMvcConfigurer{

//
//    //Session local resolver what ties  our current session to a locale
//    @Bean
//    public LocaleResolver localeResolver(){
//        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
//        sessionLocaleResolver.setDefaultLocale(Locale.ENGLISH);
//        return sessionLocaleResolver;
//    }
//
//    //the param name we want to Intercept the change
//     @Bean
//     public LocaleChangeInterceptor localeChangeInterceptor(){
//         LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
//         localeChangeInterceptor.setParamName("lang");
//         return localeChangeInterceptor;
//     }
//
//     @Bean(name = "messageSource")
//     public MessageSource messageSource(){
//        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//        messageSource.setBasenames("messages");
//        messageSource.setDefaultEncoding("UTF-8");
//        return messageSource;
//     }


}
