package com.jerry.stock_java.service;

import com.jerry.stock_java.dao.UserDao;
import com.jerry.stock_java.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    @Autowired
    private UserDao userDao;

    public User getUsersByName(String user_name){return userDao.getUsersByName(user_name);}

    public int getUserIdByName(String user_name){
        User user = userDao.getUsersByName(user_name);
        return user.getUser_id();
    }

    public String getPasswordByName(String user_name){
        User user = userDao.getUsersByName(user_name);
        return user.getUser_password();
    }
}
