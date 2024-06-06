package com.jerry.stock_java.rowmapper;

import com.jerry.stock_java.model.Stock;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StockRowMapper implements RowMapper<Stock> {
    @Override
    public Stock mapRow(ResultSet rs, int rowNum) throws SQLException {
        Stock stock = new Stock();
        stock.setStock_id(rs.getString("stock_id"));
        stock.setStock_name(rs.getString("stock_name"));
        return stock;
    }
}
