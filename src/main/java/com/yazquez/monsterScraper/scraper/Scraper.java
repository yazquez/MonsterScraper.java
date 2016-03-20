package com.yazquez.monsterScraper.scraper;

import java.util.List;

import com.yazquez.monsterScraper.entities.SearchEntity;

public interface Scraper {
    void processSearchs(List<SearchEntity> searchs) throws Exception;

}