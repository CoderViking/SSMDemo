package com.ssm.model;

/**
 * Created by viking on 2018/07/08
 * book实体类
 */
public class Book {
    private Integer id;
    private String bookName;
    private Float prices;
    private String uid;

    public Integer getId() {
        return id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Float getPrices() {
        return prices;
    }

    public void setPrices(Float prices) {
        this.prices = prices;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
