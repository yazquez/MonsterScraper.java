package com.yazquez.monsterScraper.scraper;

import java.util.List;
import java.util.Random;

import com.yazquez.monsterScraper.entities.SearchEntity;

public class MockScraper implements Scraper {

    public MockScraper() {
    }

    @Override
    public void processSearchs(List<SearchEntity> searchs) throws Exception {
        for (SearchEntity search : searchs) {
            search.setResult(new Random().nextInt(1000));
            System.out.println(search.toCsv());
        }
    }
}
