package com.yazquez.monsterScraper.entities;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.yazquez.monsterScraper.entities.SearchEntity;

public class SearchEntityTest {

    private SearchEntity searchEntity;
    private String stringDate = new SimpleDateFormat("yyyy/MM/dd").format(new Date());

    @Before
    public void setUp() {
        searchEntity = new SearchEntity("ie", "dublin", "hadoop").setResult(69);
    }

    @Test
    public void searchEntityGetDateShouldBeCurrentDate() {
        assertEquals(searchEntity.getDate(), stringDate);
    }

    @Test
    public void toJson() {
        String expected = String.format("{date:'%s', country:'%s', city:'%s', technology:'%s', offerts:'%s' }",
                stringDate, "ie", "dublin", "hadoop", 69);
        assertEquals(expected, searchEntity.toJson());
    }

    @Test
    public void toCsv() {
        String expected = String.format("%s,%s,%s,%s,%s", stringDate, "ie", "dublin", "hadoop", 69);
        assertEquals(expected, searchEntity.toCsv());
    }

}
