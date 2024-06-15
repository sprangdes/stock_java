package com.jerry.stock_java.dao;

import com.jerry.stock_java.model.Hold;
import com.jerry.stock_java.rowmapper.HoldRowMapper;
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
public class HoldDao {

    @Autowired
    private NamedParameterJdbcTemplate nameParameterJdbcTemplate;

    public Hold getHoldById(long hold_id) {
        String sql = "SELECT * FROM userHolds WHERE id = :hold_id";
        Map<String, Object> map = new HashMap<>();
        map.put("hold_id", hold_id);
        List<Hold> holdList = nameParameterJdbcTemplate.query(sql, map, new HoldRowMapper());
        if(!holdList.isEmpty()) {
            return holdList.get(0);
        }else{
            return null;
        }
    }

    public List<Hold> getHoldByUser(String user_name) {
        String sql = "SELECT * FROM userHolds WHERE user_name = :user_name";
        Map<String, Object> map = new HashMap<>();
        map.put("user_name", user_name);
        List<Hold> holdList = nameParameterJdbcTemplate.query(sql, map, new HoldRowMapper());
        if(!holdList.isEmpty()) {
            return holdList;
        }else{
            return null;
        }
    }

    public long createHold(Hold hold) {
        String sql = "INSERT INTO userHolds(user_name, stock_code, shares_hold) VALUES(:user_name, :stock_code, :shares_hold)";
        Map<String, Object> map = new HashMap<>();
        map.put("user_name", hold.getUser_name());
        map.put("stock_code", hold.getStock_code());
        map.put("shares_hold", hold.getShares_hold());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        nameParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);
        return keyHolder.getKey().longValue();
    }

    public void updateHoldShare(Hold hold) {
        String sql = "UPDATE userHolds SET shares_hold = :shares_hold WHERE id = :hold_id";
        Map<String, Object> map = new HashMap<>();
        map.put("shares_hold", hold.getShares_hold());
        map.put("hold_id", hold.getId());
        nameParameterJdbcTemplate.update(sql, map);
    }

    public void deleteHold(long hold_id) {
        String sql = "DELETE FROM userHolds WHERE id = :hold_id";
        Map<String, Object> map = new HashMap<>();
        map.put("hold_id", hold_id);
        nameParameterJdbcTemplate.update(sql, map);
    }
}
