package com.jerry.stock_java.controller;

import com.jerry.stock_java.dto.StockCodeRequest;
import com.jerry.stock_java.dto.StockNameRequest;
import com.jerry.stock_java.model.Stock;
import com.jerry.stock_java.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping("/stocks/{stock_code}")
    public ResponseEntity<Stock> getStockByCode(@PathVariable String stock_code) {
        Stock stock = stockService.getStockByCode(stock_code);
        if (stock != null) {
            return ResponseEntity.status(HttpStatus.OK).body(stock);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/stocks")
    public ResponseEntity<Stock> createStock(@RequestBody Stock stock) {
        String stock_code_created = stock.getStock_code();
        stockService.createStock(stock);
        Stock stock_created = stockService.getStockByCode(stock_code_created);
        if(stock_created != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(stock_created);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/stocks/{stock_code}/stockCode")
    public ResponseEntity<Stock> updateStockCode(@PathVariable String stock_code, @RequestBody StockCodeRequest stockCodeRequest) {
        String new_stock_code = stockCodeRequest.getStock_code();
        stockService.updateStockCode(stock_code, new_stock_code);
        return ResponseEntity.status(HttpStatus.OK).body(stockService.getStockByCode(new_stock_code));
    }

    @PutMapping("/stocks/{stock_code}/stockName")
    public ResponseEntity<Stock> updateStockName(@PathVariable String stock_code, @RequestBody StockNameRequest stockNameRequest) {
        String new_stock_name = stockNameRequest.getStock_name();
        stockService.updateStockName(stock_code, new_stock_name);
        return ResponseEntity.status(HttpStatus.OK).body(stockService.getStockByCode(stock_code));
    }

    @DeleteMapping("/stocks/{stock_code}")
    public ResponseEntity<?> deleteStockByCode(@PathVariable String stock_code) {
        stockService.deleteStockByCode(stock_code);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
