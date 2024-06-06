package com.jerry.stock_java.rowmapper;

import com.jerry.stock_java.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setUser_id(rs.getInt("user_id"));
        user.setUser_name(rs.getString("user_name"));
        user.setUser_password(rs.getString("user_password"));
        return user;
    }
}
