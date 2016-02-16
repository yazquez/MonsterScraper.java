package com.yazquez.monsterCrawler.crawler;

import java.util.List;
import java.util.Random;

import com.yazquez.monsterCrawler.entities.SearchEntity;

public class MockCrawler implements Crawler {

    private List<SearchEntity> searchs;

    public MockCrawler(List<SearchEntity> searchs) {
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
