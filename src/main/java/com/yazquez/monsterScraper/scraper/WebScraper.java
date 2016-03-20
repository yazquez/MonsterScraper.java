package com.yazquez.monsterScraper.scraper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yazquez.monsterScraper.entities.SearchEntity;

public class WebScraper implements Scraper {

	private static final int DELAY = 1000;
    private static final String PROPERTIES_LINE_PATTERN = "_m.ATM.properties=";
    private static final String PROPERTY_KEY = "eVar23";
    private static final String URL_SEARCH = "http://jobsearch.monster.%s/jobs/?q=%s";

    private List<SearchEntity> searchs;

    public WebScraper(List<SearchEntity> searchs) {
        this.searchs = searchs;
    }


    @Override
    public void processSearchs() throws Exception {
        for (SearchEntity search : searchs) {
            search.setResult(processKeyWord(search.getTechnology(), search.getCountry(), search.getCity()));
            Thread.sleep(DELAY);
            System.out.println(search.toCsv());
        }
    }

    private Integer processKeyWord(String keyWord, String country, String where) throws Exception {
        if (!where.isEmpty()) {
            keyWord += "&where=" + where;
        }
        URL url = new URL(String.format(URL_SEARCH, country, keyWord));
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
        String line;
        String occurencesNumber = "Zero";
        while (null != (line = br.readLine())) {
            if (line.contains(PROPERTIES_LINE_PATTERN)) {
                occurencesNumber = extractOccurencesNumber(line);
                break;
            }
        }
        return (occurencesNumber.equals("Zero") ? 0 : Integer.parseInt(occurencesNumber));
    }

    public static String extractOccurencesNumber(String line) throws Exception {
        String firstLine = line.split(";")[0];
        firstLine = firstLine.substring(PROPERTIES_LINE_PATTERN.length());

        Map<String, Object> propertiesMap = new ObjectMapper().readValue(firstLine,
                new TypeReference<Map<String, String>>() {
                });

        return propertiesMap.get(PROPERTY_KEY).toString();
    }
}
