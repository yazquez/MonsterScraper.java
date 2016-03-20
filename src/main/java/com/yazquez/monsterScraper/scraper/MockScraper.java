package com.yazquez.monsterScraper.scraper;

import java.util.List;
import java.util.Random;

import com.yazquez.monsterScraper.entities.SearchEntity;

public class MockScraper implements Scraper {

    private List<SearchEntity> searchs;

    public MockScraper(List<SearchEntity> searchs) {
        this.searchs = searchs;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.yazquez.monsterCrawler.crawler.Crawler#processSearchs()
     */
    @Override
    public void processSearchs() throws Exception {
        for (SearchEntity search : searchs) {
            search.setResult(new Random().nextInt(1000));
            System.out.println(search.toCsv());
        }
    }
}
