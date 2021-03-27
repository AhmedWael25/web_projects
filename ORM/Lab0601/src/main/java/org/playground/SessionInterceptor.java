package org.playground;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
import org.playground.domain.Category;
import org.playground.domain.User;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class SessionInterceptor extends EmptyInterceptor {


    @Override
    public void onDelete(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        super.onDelete(entity, id, state, propertyNames, types);
    }

    @Override
    public boolean onLoad(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {

        System.out.println("Entity Loaded Is: "+ entity);
        System.out.println("Entity Loaded Is: "+ id);
        System.out.println("Entity Loaded Is: "+ Arrays.toString(state));
        System.out.println("Entity Loaded Is: "+ Arrays.toString(propertyNames));
        System.out.println("Entity Loaded Is: "+ Arrays.toString(types));

        return super.onLoad(entity, id, state, propertyNames, types);
    }

    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {



        if(entity instanceof User){
            System.out.println("Entity is of CATEGORY");
            ((User)entity).setUserName("new");
            System.out.println("Entity Created Is: "+ entity);
            System.out.println("Entity Created Is: "+ id);
            System.out.println("Entity Created Is: "+ Arrays.toString(state));
            System.out.println("Entity Created Is: "+ Arrays.toString(propertyNames));
            System.out.println("Entity Created Is: "+ Arrays.toString(types));
        }

        System.out.println("asas" +entity);
        System.out.println(entity.hashCode());


        new Scanner(System.in).nextLine();

        return  false;
//        return super.onSave(entity, id, state, propertyNames, types);
    }


    @Override
    public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types) {

        if(entity instanceof User){
            System.out.println("User Changed yasta");
        }
        System.out.println("Object "+entity+" Updated");

        return super.onFlushDirty(entity, id, currentState, previousState, propertyNames, types);
    }

    @Override
    public void postFlush(Iterator entities) {
        super.postFlush(entities);
    }



}
