package com.fittect1;

/**
 * Created by prasang on 24/6/16.
 */
public class ResultItem {
    private String name, description, address, rate;
    private int thumbnail;

    public ResultItem() {}

    public ResultItem(String name, String description, String address, String rate, int thumbnail) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.rate = rate;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getRate() {
        return rate;
    }
    public void setRate(String rate) {
        this.rate = rate;
    }

    public int getThumbnail() {
        return thumbnail;
    }
    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
