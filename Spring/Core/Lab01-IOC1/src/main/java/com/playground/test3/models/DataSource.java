package com.playground.test3.models;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class DataSource {

    private String admin;
    private String url;
    private String password;
    
    public  DataSource(String a, String u, String p){
        System.out.println("DataSource: DataSource(String a, String u, String p)");

        admin = a ;
        url = u;
        password = p;
        System.out.println("admin="+a +", url="+url + ", password="+p);
    }

}
