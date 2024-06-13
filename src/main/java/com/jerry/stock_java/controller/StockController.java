package com.jerry.stock_java.controller;

import com.jerry.stock_java.dto.StockIdRequest;
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

    @GetMapping("/stocks/{stock_id}")
    public ResponseEntity<Stock> getStockById(@PathVariable String stock_id) {
        Stock stock = stockService.getStockById(stock_id);
        if (stock != null) {
            return ResponseEntity.status(HttpStatus.OK).body(stock);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/stocks")
    public ResponseEntity<Stock> createStock(@RequestBody Stock stock) {
        String stock_id_created = stock.getStock_id();
        stockService.createStock(stock);
        Stock stock_created = stockService.getStockById(stock_id_created);
        if(stock_created != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(stock_created);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/stocks/{stock_id}/stockId")
    public ResponseEntity<Stock> updateStockId(@PathVariable String stock_id, @RequestBody StockIdRequest stockIdRequest) {
        String new_stock_id = stockIdRequest.getStock_id();
        stockService.updateStockId(stock_id, new_stock_id);
        return ResponseEntity.status(HttpStatus.OK).body(stockService.getStockById(new_stock_id));
    }

    @PutMapping("/stocks/{stock_id}/stockName")
    public ResponseEntity<Stock> updateStockName(@PathVariable String stock_id, @RequestBody StockNameRequest stockNameRequest) {
        String new_stock_name = stockNameRequest.getStock_name();
        stockService.updateStockName(stock_id, new_stock_name);
        return ResponseEntity.status(HttpStatus.OK).body(stockService.getStockById(stock_id));
    }

    public ResponseEntity<?> deleteStock(@PathVariable String stock_id) {
        stockService.deleteStock(stock_id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
