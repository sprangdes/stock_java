package com.jerry.stock_java.rowmapper;

import com.jerry.stock_java.model.Hold;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HoldRowMapper implements RowMapper<Hold> {
    @Override
    public Hold mapRow(ResultSet rs, int rowNum) throws SQLException {
        Hold hold = new Hold();
        hold.setId(rs.getInt("id"));
        hold.setUser_name(rs.getString("user_name"));
        hold.setStock_code(rs.getString("stock_code"));
        hold.setShares_hold(rs.getInt("shares_hold"));
        return hold;
    }
}
