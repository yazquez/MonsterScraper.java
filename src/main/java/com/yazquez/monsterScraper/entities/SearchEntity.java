package com.yazquez.monsterScraper.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SearchEntity {
    private String date;
    private String technology;
    private String country;
    private String city;
    private Integer result = 0;

    public SearchEntity(String country, String city, String technology) {
        this.technology = technology;
        this.country = country;
        this.city = city;
        this.date = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
    }

    public String getDate() {
        return date;
    }

    public String getTechnology() {
        return technology;
    }

    public SearchEntity setTechnology(String technology) {
        this.technology = technology;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public SearchEntity setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getCity() {
        return this.city;
    }

    public SearchEntity setCity(String city) {
        this.city = city;
        return this;
    }

    public Integer getResult() {
        return result;
    }

    public SearchEntity setResult(Integer result) {
        this.result = result;
        return this;
    }

    public String toJson() {
        return String.format("{date:'%s', country:'%s', city:'%s', technology:'%s', offerts:'%s'}", this.getDate(),
                this.getCountry(), this.getCity(), this.getTechnology(), this.getResult().toString());
    }

    public String toCsv() {
        return String.format("%s,%s,%s,%s,%s", this.getDate(), this.getCountry(), this.getCity(), this.getTechnology(),
                this.getResult().toString());
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s", this.date, this.country, this.getCity(), this.technology);
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this.hashCode() == obj.hashCode();
    }

}
