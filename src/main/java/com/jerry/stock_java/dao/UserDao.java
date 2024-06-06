package com.jerry.stock_java.dao;

import com.jerry.stock_java.model.User;
import com.jerry.stock_java.rowmapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public User getUsersByName(String user_name) {
        String sql = "SELECT user_id, user_name, user_password FROM users WHERE user_name = :user_name";
        Map<String, Object> map = new HashMap<>();
        map.put("user_name", user_name);
        List<User> userList =  namedParameterJdbcTemplate.query(sql, map, new UserRowMapper());

        if(!userList.isEmpty()){
            return userList.get(0);
        }else{
            return null;
        }
    }
}
