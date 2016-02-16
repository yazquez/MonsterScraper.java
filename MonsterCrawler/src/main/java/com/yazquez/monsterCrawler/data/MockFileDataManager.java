package com.yazquez.monsterCrawler.data;

import java.util.ArrayList;
import java.util.List;

import com.yazquez.monsterCrawler.entities.SearchEntity;

public class MockFileDataManager implements DataManager {

	
	
	private List<SearchEntity> searchs = new ArrayList<SearchEntity>();
	private String[] technologies = {"spark","hadoop","mongodb","scala","cassandra","angular"};
	
	public MockFileDataManager(){
		this.loadSearchs();
	}
	
	private void loadSearchs(){
		addSearchByTechnology(technologies,"co.uk","");
		addSearchByTechnology(technologies,"co.uk","london");
		addSearchByTechnology(technologies,"co.uk","reading");
		addSearchByTechnology(technologies,"co.uk","brighton");
		addSearchByTechnology(technologies,"co.uk","belfast");
		addSearchByTechnology(technologies,"ie","");
		addSearchByTechnology(technologies,"ie","dublin");
		addSearchByTechnology(technologies,"ie","cork");
		addSearchByTechnology(technologies,"ie","athlone");
		addSearchByTechnology(technologies,"ie","galway");
//		addSearchByTechnology(technologies,"es","");
//		addSearchByTechnology(technologies,"es","madrid");
//		addSearchByTechnology(technologies,"es","barcelona");
//		addSearchByTechnology(technologies,"es","sevilla");
//		addSearchByTechnology(technologies,"es","malaga");
		
	}
	
	private void addSearchByTechnology(String[] keyWords, String country, String city) {
    	for(String keyWord : keyWords){
    		getSearchs().add(new SearchEntity(keyWord, country, city));
    	}
	}

	/* (non-Javadoc)
	 * @see com.yazquez.monsterCrawler.data.DataManager#getSearchs()
	 */
	public List<SearchEntity> getSearchs() {
		return searchs;
	}

	public void setSearchs(List<SearchEntity> searchs) {
		this.searchs = searchs;
	}
	
	/* (non-Javadoc)
	 * @see com.yazquez.monsterCrawler.data.DataManager#saveSearchs()
	 */
	public void saveSearchs(){
	}
}
