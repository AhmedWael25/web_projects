package com.playground.test4;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ScopeMetadata;
import org.springframework.context.annotation.ScopeMetadataResolver;

import java.util.Arrays;

public class CustomScope implements ScopeMetadataResolver {
    @Override
    public ScopeMetadata resolveScopeMetadata(BeanDefinition beanDefinition) {

        System.out.println(beanDefinition);
        /* Print =>
            Generic bean: class [com.playground.test4.models.Parent]; scope=;
            abstract=false; lazyInit=null; autowireMode=0; dependencyCheck=0; autowireCandidate=true; primary=false;
            factoryBeanName=null; factoryMethodName=null; initMethodName=null;
            destroyMethodName=null; defined in class path resource [com/playground/test4/models/Parent.class]
        */
        ScopeMetadata x = new ScopeMetadata();

        return x;
    }
}
