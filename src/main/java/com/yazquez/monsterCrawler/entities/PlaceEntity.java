package com.yazquez.monsterCrawler.entities;

public class PlaceEntity {

    private String country;
    private String city;

    @Override
    public String toString() {
        return String.format("{country:'%s', city:'%s'}", this.getCountry(), this.getCity());
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
