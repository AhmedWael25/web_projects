package com.playground.initializers;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import com.playground.configs.RootAppConfig;
import com.playground.configs.WebAppConfig;

import org.springframework.cglib.proxy.Dispatcher;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

    @Override
    protected  Class<?>[] getRootConfigClasses(){
        return new Class<?>[]{RootAppConfig.class};
    }  

    @Override   
    protected  Class<?>[] getServletConfigClasses(){
        return new Class<?>[]{WebAppConfig.class};
    }

    @Override
    protected  String[] getServletMappings(){
        return new String[]{"*.htm"};
    }

}


// implements WebApplicationInitializer{

        // @Override
        // public void onStartup(ServletContext servletContext) throws ServletException{

        //     XmlWebApplicationContext appContext = new XmlWebApplicationContext();
        //     appContext.setConfigLocation("/WEB-INF/spring/mvc.xml");
           
        //     DispatcherServlet servlet = new DispatcherServlet(appContext);
        //     ServletRegistration.Dynamic registeration = servletContext.addServlet("mvc-dispatcher",servlet);

        //     registeration.setLoadOnStartup(1);
        //     registeration.addMapping("*.htm");
        // }