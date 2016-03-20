package com.yazquez.monsterScraper.scraper;

import com.yazquez.monsterScraper.data.DataManager;
import com.yazquez.monsterScraper.data.TextFileDataManager;

public class App {

	public static void main(String[] args) throws Exception {
		DataManager dataManager = new TextFileDataManager();
		Scraper scraper = new WebScraper(dataManager.getSearchs());
		// Scraper scraper = new MockScraper(dataManager.getSearchs());
		scraper.processSearchs();
		dataManager.saveResults();
	}
}