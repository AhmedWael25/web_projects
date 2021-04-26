package com.playground.test3;

import com.playground.test3.models.Parent;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;

public class CustomScope implements ScopeMetadataResolver {
    @Override
    public ScopeMetadata resolveScopeMetadata(BeanDefinition beanDefinition) {

        System.out.println(beanDefinition);
        /* Print =>
            Generic bean: class [com.playground.test3.models.Parent]; scope=;
            abstract=false; lazyInit=null; autowireMode=0; dependencyCheck=0; autowireCandidate=true; primary=false;
            factoryBeanName=null; factoryMethodName=null; initMethodName=null;
            destroyMethodName=null; defined in class path resource [com/playground/test3/models/Parent.class]
        */

        ScopeMetadata x = new ScopeMetadata();

        return x;
    }
}
