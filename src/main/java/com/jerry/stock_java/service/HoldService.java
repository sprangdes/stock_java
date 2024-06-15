package com.jerry.stock_java.service;

import com.jerry.stock_java.dao.HoldDao;
import com.jerry.stock_java.model.Hold;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HoldService {

    @Autowired
    private HoldDao holdDao;

    public Hold getHoldById(long hold_id) {
        return holdDao.getHoldById(hold_id);
    }

    public List<Hold> getHoldByUser(String user_name) {
        return holdDao.getHoldByUser(user_name);
    }

    public long createHold(Hold hold) {
        return holdDao.createHold(hold);
    }

    public void updateHoldShare(long hold_id, int shares_hold) {
        Hold hold = holdDao.getHoldById(hold_id);
        hold.setShares_hold(shares_hold);
        holdDao.updateHoldShare(hold);
    }

    public void deleteHold(long hold_id) {
        holdDao.deleteHold(hold_id);
    }

}
