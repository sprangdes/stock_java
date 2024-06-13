package com.jerry.stock_java.dao;

import com.jerry.stock_java.model.Stock;
import com.jerry.stock_java.rowmapper.StockRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class StockDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public Stock getStockById(String stock_id){
        String sql = "SELECT stock_id, stock_name FROM stocks WHERE stock_id = :stock_id";
        Map<String, Object> map = new HashMap<>();
        map.put("stock_id", stock_id);
        List<Stock> stockList = namedParameterJdbcTemplate.query(sql, map, new StockRowMapper());
        if(!stockList.isEmpty()){
            return stockList.get(0);
        }else{
            return null;
        }
    }

    public void createStock(Stock stock){
        String sql = "INSERT INTO stocks(stock_id, stock_name) VALUES(:stock_id, :stock_name)";
        Map<String, Object> map = new HashMap<>();
        map.put("stock_id", stock.getStock_id());
        map.put("stock_name", stock.getStock_name());
        namedParameterJdbcTemplate.update(sql, map);
    }

    public void updateStock(Stock stock){
        String sql = "UPDATE stocks SET stock_id = :stock_id, stock_name = :stock_name WHERE stock_id = :stock_id";
        Map<String, Object> map = new HashMap<>();
        map.put("stock_id", stock.getStock_id());
        map.put("stock_name", stock.getStock_name());
        namedParameterJdbcTemplate.update(sql, map);
    }

    public void deleteStockById(String stock_id){
        String sql = "DELETE FROM stocks WHERE stock_id = :stock_id";
        Map<String, Object> map = new HashMap<>();
        map.put("stock_id", stock_id);
        namedParameterJdbcTemplate.update(sql, map);
    }
}
