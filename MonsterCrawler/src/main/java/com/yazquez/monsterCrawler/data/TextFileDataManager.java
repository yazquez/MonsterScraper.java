package com.yazquez.monsterCrawler.data;

import java.util.ArrayList;
import java.util.List;

import com.yazquez.monsterCrawler.entities.SearchEntity;

public class TextFileDataManager implements DataManager {

    List<SearchEntity> searchs = new ArrayList<SearchEntity>();
    List<String> technologies = new ArrayList<String>();

    public TextFileDataManager() {
        this.loadSearchs();
    }

    private void loadSearchs() {
    }

    private void addSearchByTechnology(String[] keyWords, String country, String city) {
        for (String keyWord : keyWords) {
            getSearchs().add(new SearchEntity(keyWord, country, city));
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.yazquez.monsterCrawler.data.DataManager#getSearchs()
     */
    public List<SearchEntity> getSearchs() {
        return searchs;
    }

    public void setSearchs(List<SearchEntity> searchs) {
        this.searchs = searchs;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.yazquez.monsterCrawler.data.DataManager#saveSearchs()
     */
    public void saveResults() {
    }
}
