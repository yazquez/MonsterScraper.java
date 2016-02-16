package com.yazquez.monsterCrawler.crawler;

import com.yazquez.monsterCrawler.data.DataManager;
import com.yazquez.monsterCrawler.data.TextFileDataManager;

public class App {

    public static void main(String[] args) throws Exception {
        DataManager dataManager = new TextFileDataManager();
        Crawler crawler = new WebCrawler(dataManager.getSearchs());
        // Crawler crawler = new MockCrawler(dataManager.getSearchs());
        crawler.processSearchs();
        dataManager.saveResults();
    }
}