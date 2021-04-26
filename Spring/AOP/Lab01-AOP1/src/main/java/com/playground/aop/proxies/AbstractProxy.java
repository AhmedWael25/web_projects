package com.playground.aop.proxies;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.playground.aop.advices.GeneralAdvice;

import java.lang.reflect.*;

public class AbstractProxy implements InvocationHandler{
    
    private final Object targetObject;
    private final GeneralAdvice generalAdvice = new GeneralAdvice();

    private AbstractProxy(Object obj){
        this.targetObject = obj;
    }

    public static Object newInstance(Object obj){
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new AbstractProxy(obj));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        
        Object result = null;


        try{
            generalAdvice.before(args);

            result = method.invoke(targetObject, args);

            generalAdvice.after(result);
        }catch(Exception e){    
            generalAdvice.afterThrows(e);
        }
        return result;
    }

}
