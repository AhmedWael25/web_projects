package com.playground;

import java.util.ArrayList;
import java.util.List;

public class HelloServiceImpl implements  HelloService{

    List<String> users = new ArrayList<>();

    public HelloServiceImpl(){
        for (int i = 0 ; i < 5 ; i ++){
            users.add("SOME STRING > "+i);
        }
    }


    @Override
    public String userAccess() {
        return "This is user ONLY Access";
    }

    @Override
    public String adminAccess() {
        return "This is admin ONLY Access";
    }

    @Override
    public String allAccess() {
        return "This is Accessible to All  users";
    }

    @Override
    public String denyAllAccess() {
        return "Denied Access For All";
    }

    @Override
    public String addStringAdminOnly(String str) {
        users.add(str);
        return "Admin Added a new String of value = " + str;
    }

    @Override
    public String returnString() {
        return "admin";
    }

    @Override
    public List<String> getAllStrings() {
        return users;
    }


}
