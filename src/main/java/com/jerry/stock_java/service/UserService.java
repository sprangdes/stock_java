package com.jerry.stock_java.service;

import com.jerry.stock_java.dao.UserDao;
import com.jerry.stock_java.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    @Autowired
    private UserDao userDao;

    public User getUserById(int user_id) {
        return userDao.getUsersById(user_id);
    }

    public int createUser(User user){
        return userDao.createUser(user);
    }

    public void updateUserName(int user_id, String new_user_name){
        User user = getUserById(user_id);
        user.setUser_name(new_user_name);
        userDao.updateUser(user);
    }

    public void updateUserPassword(int user_id, String new_user_password){
        User user = getUserById(user_id);
        user.setUser_password(new_user_password);
        userDao.updateUser(user);
    }

    public void deleteUser(int user_id){
        userDao.deleteUser(user_id);
    }
}
