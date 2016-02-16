package com.yazquez.monsterCrawler.entities;

import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

public class SearchEntityTest {

    private static SearchEntity searchEntity;
    private static String stringDate = new SimpleDateFormat("yyyy/MM/dd").format(new Date());

    @BeforeClass
    public static void oneTimeSetUp() {
        searchEntity = new SearchEntity("hadoop", "ie", "dublin").setResult(69);
    }

    @Test
    public void searchEntityGetDateShouldBeCurrentDate() {
        assertTrue(new SimpleDateFormat("yyyy/MM/dd").format(searchEntity.getDate()).equals(stringDate));
    }

    @Test
    public void toJson() {
        String expected = String.format("{date:'%s', country:'%s', city:'%s', technology:'%s', offerts:'%s' }",
                stringDate, "ie", "dublin", "hadoop", 69);
        assertTrue(searchEntity.toJson().equals(expected));
    }

    @Test
    public void toCsv() {
        String expected = String.format("%s,%s,%s,%s,%s", stringDate, "ie", "dublin", "hadoop", 69);
        assertTrue(searchEntity.toCsv().equals(expected));
    }

}
