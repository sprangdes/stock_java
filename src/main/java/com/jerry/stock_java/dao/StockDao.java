package com.jerry.stock_java.dao;

import com.jerry.stock_java.model.Stock;
import com.jerry.stock_java.rowmapper.StockRowMapper;
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
public class StockDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public Stock getStockByCode(String stock_code){
        String sql = "SELECT stock_id, stock_code, stock_name FROM stocks WHERE stock_code = :stock_code";
        Map<String, Object> map = new HashMap<>();
        map.put("stock_code", stock_code);
        List<Stock> stockList = namedParameterJdbcTemplate.query(sql, map, new StockRowMapper());
        if(!stockList.isEmpty()){
            return stockList.get(0);
        }else{
            return null;
        }
    }

    public int createStock(Stock stock){
        String sql = "INSERT INTO stocks(stock_code, stock_name) VALUES(:stock_code, :stock_name)";
        Map<String, Object> map = new HashMap<>();
        map.put("stock_code", stock.getStock_code());
        map.put("stock_name", stock.getStock_name());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);
        return keyHolder.getKey().intValue();
    }

    public void updateStock(Stock stock){
        String sql = "UPDATE stocks SET stock_code = :stock_code, stock_name = :stock_name WHERE stock_id = :stock_id";
        Map<String, Object> map = new HashMap<>();
        map.put("stock_id", stock.getStock_id());
        map.put("stock_code", stock.getStock_code());
        map.put("stock_name", stock.getStock_name());
        namedParameterJdbcTemplate.update(sql, map);
    }

    public void deleteStockByCode(String stock_code){
        String sql = "DELETE FROM stocks WHERE stock_code = :stock_code";
        Map<String, Object> map = new HashMap<>();
        map.put("stock_code", stock_code);
        namedParameterJdbcTemplate.update(sql, map);
    }
}
