package com.yazquez.monsterCrawler.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SearchEntity {
    private Date date;
    private String technology;
    private String country;
    private String city;
    private Integer result;

    public SearchEntity(String technology, String country, String city) {
        this.technology = technology;
        this.country = country;
        this.city = city;
        this.date = new Date();
    }

    public Date getDate() {
        return date;
    }

    public SearchEntity setDate(Date date) {
        this.date = date;
        return this;
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
        return city;
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
        String stringDate = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
        return String.format("{date:'%s', country:'%s', city:'%s', technology:'%s', offerts:'%s' }", stringDate,
                this.country, (this.city.isEmpty() ? "anywhere" : city), this.technology, this.result.toString());
    }

    public String toCsv() {
        String stringDate = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
        return String.format("%s,%s,%s,%s,%s", stringDate, this.country, (this.city.isEmpty() ? "anywhere" : city),
                this.technology, this.result.toString());
    }

}
