package com.jerry.stock_java.model;

public class Hold {

    private int id;
    private int user_id;
    private String stock_id;
    private int shares_hold;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getStock_id() {
        return stock_id;
    }

    public void setStock_id(String stock_id) {
        this.stock_id = stock_id;
    }

    public int getShares_hold() {
        return shares_hold;
    }

    public void setShares_hold(int shares_hold) {
        this.shares_hold = shares_hold;
    }
}
