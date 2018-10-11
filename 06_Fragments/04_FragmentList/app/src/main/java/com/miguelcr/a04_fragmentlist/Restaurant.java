package com.miguelcr.a04_fragmentlist;

public class Restaurant {
    private String name;
    private int rate;
    private String address;
    private String photoUrl;

    public Restaurant(String name, int rate, String address, String photoUrl) {
        this.name = name;
        this.rate = rate;
        this.address = address;
        this.photoUrl = photoUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
