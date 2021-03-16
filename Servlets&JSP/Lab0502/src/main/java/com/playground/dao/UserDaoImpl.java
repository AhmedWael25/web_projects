package com.playground.dao;


import com.playground.model.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public  class UserDaoImpl implements  UserDao{




    @Override
    public boolean saveUser(User user) throws SQLException {
        String query = "INERT INTO users(fname,lname,uname) VALUES(?,?,?)";

        return false;
    }

    @Override
    public User getUser(String userName) throws SQLException {
        return null;
    }
}