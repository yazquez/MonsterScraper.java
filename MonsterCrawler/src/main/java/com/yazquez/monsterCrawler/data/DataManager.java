package com.yazquez.monsterCrawler.data;

import java.util.List;

public interface DataManager {

	List<SearchEntity> getSearchs();

	void saveSearchs();

}