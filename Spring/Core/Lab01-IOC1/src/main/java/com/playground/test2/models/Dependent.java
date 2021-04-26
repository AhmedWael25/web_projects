package com.playground.test2.models;

import lombok.*;

@Setter @Getter
public class Dependent{


    Dependent(){
       System.out.println("Dependent Bean got initialized : Dependent() ...");
    }

}