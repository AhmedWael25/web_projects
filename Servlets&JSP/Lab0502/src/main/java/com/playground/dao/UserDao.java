package com.playground.dao;

import com.playground.model.User;

import java.sql.SQLException;

public interface UserDao {

 boolean saveUser(User user)throws SQLException;
 User getUser(String userName) throws  SQLException;

}