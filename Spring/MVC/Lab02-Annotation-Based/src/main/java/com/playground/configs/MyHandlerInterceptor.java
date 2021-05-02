package com.playground.configs;

import javax.servlet.http.*;

import org.springframework.lang.Nullable;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyHandlerInterceptor implements HandlerInterceptor{
    

    @Override
     public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		System.out.println("In My Custom pre Handle Interceptor --This rune before request is handled");
        return true;
	}

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {

        System.out.println("In My Custom POST Handle Interceptor:- This runs after request is handled but befor view is generatd ");
        modelAndView.addObject("addedObject", "I Was Added From an Interceptor, Printing web application context");

        WebApplicationContext webApplicationContext = (WebApplicationContext)request.getAttribute(DispatcherServlet.WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        modelAndView.addObject("context", webApplicationContext);

        System.out.println(webApplicationContext);
        System.out.println("Getting Beans : "+webApplicationContext.getBeanDefinitionCount());

        System.out.println("Model and view are =>"+modelAndView);

	}


}
