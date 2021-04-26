package com.playground.test2.service2;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Properties;

import lombok.*;


@Setter @Getter
public class CollectionsTesting {

    List myList;
    Map myMap ;
    Set mySet;
    Properties myProps;


    CollectionsTesting(List list){
        myList = list;
        System.out.println(" Collections Testing: CollectionsTesting(List list)");
        System.out.println("List: "+ myList);
        System.out.println("List Type: "+ myList.getClass());
    }

    CollectionsTesting(Map map){
        myMap = map;
        System.out.println(" Collections Testing: CollectionsTesting(Map map)");
        System.out.println("Map: "+ myMap);
        System.out.println("Map Type: "+ myMap.getClass());
    }

    CollectionsTesting(Set set){
        mySet = set;
        System.out.println(" Collections Testing: CollectionsTesting(Set set)");
        System.out.println("Set: "+ mySet);
        System.out.println("Set Type: "+ mySet.getClass());
    }

    CollectionsTesting(Properties props){
        myProps = props;
        System.out.println(" Collections Testing: CollectionsTesting(Properties props)");
        System.out.println("Props: "+ props);
        System.out.println("Props Type: "+ props.getClass());
    }





}