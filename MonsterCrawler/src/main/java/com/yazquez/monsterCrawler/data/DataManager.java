package com.yazquez.monsterCrawler.data;

import java.util.List;

import com.yazquez.monsterCrawler.entities.SearchEntity;

public interface DataManager {

	List<SearchEntity> getSearchs();

	void saveSearchs();

}