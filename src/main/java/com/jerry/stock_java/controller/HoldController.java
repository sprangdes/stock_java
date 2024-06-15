package com.jerry.stock_java.controller;

import com.jerry.stock_java.dto.HoldShareRequest;
import com.jerry.stock_java.model.Hold;
import com.jerry.stock_java.service.HoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HoldController {

    @Autowired
    private HoldService holdService;

    @GetMapping("/holds/hold_id/{hold_id}")
    public ResponseEntity<Hold> getHoldById(@PathVariable long hold_id) {
        Hold hold = holdService.getHoldById(hold_id);
        if (hold != null) {
            return ResponseEntity.status(HttpStatus.OK).body(hold);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/holds/user/{user_name}")
    public ResponseEntity<List<Hold>> getHoldByUser(@PathVariable String user_name) {
        List<Hold> holds = holdService.getHoldByUser(user_name);
        if (holds != null) {
            return ResponseEntity.status(HttpStatus.OK).body(holds);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/holds")
    public ResponseEntity<Hold> createHold(@RequestBody Hold hold) {
        long hold_id_created = holdService.createHold(hold);
        return ResponseEntity.status(HttpStatus.CREATED).body(holdService.getHoldById(hold_id_created));
    }

    @PutMapping("/holds/{hold_id}")
    public ResponseEntity<Hold> updateHold(@PathVariable long hold_id, @RequestBody HoldShareRequest holdShareRequest) {
        int new_shares_hold = holdShareRequest.getShares_hold();
        holdService.updateHoldShare(hold_id, new_shares_hold);
        return ResponseEntity.status(HttpStatus.OK).body(holdService.getHoldById(hold_id));
    }

    public ResponseEntity<?> deleteHold(@PathVariable long hold_id) {
        holdService.deleteHold(hold_id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
