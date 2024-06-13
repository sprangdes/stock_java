package com.jerry.stock_java.service;

import com.jerry.stock_java.dao.StockDao;
import com.jerry.stock_java.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StockService {

    @Autowired
    private StockDao stockDao;

    public Stock getStockById(String stock_id) {
        return stockDao.getStockById(stock_id);
    }

    public void createStock(Stock stock) {
        stockDao.createStock(stock);
    }

    public void updateStockId(String stock_id, String new_stock_id) {
        Stock stock = stockDao.getStockById(stock_id);
        stock.setStock_id(new_stock_id);
        stockDao.updateStock(stock);
    }

    public void updateStockName(String stock_id, String new_stock_name) {
        Stock stock = stockDao.getStockById(stock_id);
        stock.setStock_name(new_stock_name);
        stockDao.updateStock(stock);
    }

    public void deleteStock(String stock_id) {
        stockDao.deleteStockById(stock_id);
    }
}
