package com.yazquez.monsterScraper.data;

import java.util.List;

import com.yazquez.monsterScraper.entities.SearchEntity;

public interface DataManager {

	List<SearchEntity> getSearchs();

	void saveResults();

}