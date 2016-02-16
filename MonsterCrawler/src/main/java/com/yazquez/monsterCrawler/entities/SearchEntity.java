package com.yazquez.monsterCrawler.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SearchEntity {
    private Date date;
    private String technology;
    private String country;
    private String city;
    private String result;

    public SearchEntity(String technology, String country, String city) {
        this.technology = technology;
        this.country = country;
        this.city = city;
        this.date = new Date();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String toJson() {
        String stringDate = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
        return String.format("{date:'%s', country:'%s', city:'%s', technology:'%s', offerts:'%s' }", stringDate,
                this.country, (this.city.isEmpty() ? "anywhere" : city), this.technology, this.result);
    }

    public String toCsv() {
        String stringDate = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
        return String.format("%s,%s,%s,%s,%s", stringDate, this.country, (this.city.isEmpty() ? "anywhere" : city),
                this.technology, this.result);
    }

}
