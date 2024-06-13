package com.jerry.stock_java.service;

import com.jerry.stock_java.dao.StockDao;
import com.jerry.stock_java.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StockService {

    @Autowired
    private StockDao stockDao;

    public Stock getStockByCode(String stock_code) {
        return stockDao.getStockByCode(stock_code);
    }

    public void createStock(Stock stock) {
        stockDao.createStock(stock);
    }

    public void updateStockCode(String stock_code, String new_stock_code) {
        Stock stock = stockDao.getStockByCode(stock_code);
        stock.setStock_code(new_stock_code);
        stockDao.updateStock(stock);
    }

    public void updateStockName(String stock_code, String new_stock_name) {
        Stock stock = stockDao.getStockByCode(stock_code);
        stock.setStock_name(new_stock_name);
        stockDao.updateStock(stock);
    }

    public void deleteStockByCode(String stock_code) {
        stockDao.deleteStockByCode(stock_code);
    }
}
