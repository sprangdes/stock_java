package com.jerry.stock_java.dao;

import com.jerry.stock_java.model.User;
import com.jerry.stock_java.rowmapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
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

    public int createUser(User user) {
        String sql = "INSERT INTO users(user_name, user_password) VALUES (:user_name, :user_password)";

        Map<String, Object> map = new HashMap<>();
        map.put("user_name", user.getUser_name());
        map.put("user_password", user.getUser_password());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);
        return keyHolder.getKey().intValue();

    }

    public int updateUser(User user) {
        String sql = "UPDATE users SET user_name = :user_name, user_password = :user_password WHERE user_id = :user_id";

        Map<String, Object> map = new HashMap<>();
        map.put("user_id", user.getUser_id());
        map.put("user_name", user.getUser_name());
        map.put("user_password", user.getUser_password());

        return namedParameterJdbcTemplate.update(sql, map);
    }
}
