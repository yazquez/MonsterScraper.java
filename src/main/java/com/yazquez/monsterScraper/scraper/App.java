package com.yazquez.monsterScraper.scraper;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yazquez.monsterScraper.data.DataManager;

public class App {

    private static ApplicationContext context;

    public static void main(String[] args) throws Exception {
        context = new ClassPathXmlApplicationContext("Spring-Config.xml");

        DataManager dataManager = (DataManager) context.getBean("dataManager");
        Scraper scraper = (Scraper) context.getBean("scraper");
        scraper.processSearchs(dataManager.getSearchs());
        dataManager.saveResults();
    }
}