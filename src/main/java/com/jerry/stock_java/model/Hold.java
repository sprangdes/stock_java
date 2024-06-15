package com.jerry.stock_java.model;

public class Hold {

    private int id;
    private String user_name;
    private String stock_code;
    private int shares_hold;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getStock_code() {
        return stock_code;
    }

    public void setStock_code(String stock_code) {
        this.stock_code = stock_code;
    }

    public int getShares_hold() {
        return shares_hold;
    }

    public void setShares_hold(int shares_hold) {
        this.shares_hold = shares_hold;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
