package com.yazquez.monsterScraper.scraper;

import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.yazquez.monsterScraper.entities.SearchEntity;

public class WebScraper implements Scraper {

    private static final int DELAY = 1000;
    private static final String URL_SEARCH = "http://jobsearch.monster.%s/jobs/?q=%s";

    public WebScraper() {
    }

    @Override
    public void processSearchs(List<SearchEntity> searchs) {
        for (SearchEntity search : searchs) {
            try {
                search.setResult(processKeyWord(search.getTechnology(), search.getCountry(), search.getCity()));
                Thread.sleep(DELAY);
                System.out.println(search.toCsv());
            } catch (Exception e) {
                System.out.println(String.format("Error processing %s [%s]", search.toJson(), e.toString()));
            }
        }
    }

    private Integer processKeyWord(String keyWord, String country, String where) throws Exception {
        if (!where.isEmpty()) {
            keyWord += "&where=" + where;
        }
        String url = String.format(URL_SEARCH, country, keyWord);

        Document document = Jsoup.connect(url).header("Accept-Encoding", "gzip, deflate")
                .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:23.0) Gecko/20100101 Firefox/23.0").maxBodySize(0)
                .timeout(600000).get();

        return searchResults(document);
    }

    private Integer searchResults(Document document) {
        Integer occurences = 0;
        String searchResult = "0";
        Elements searchResults = document.select("h2.page-title.hidden-xs");

        if (searchResults.size() == 0) {
            // Sometimes results come in a different place, check it
            searchResults = document.select("div#resultsCountHeader h1.fnt12");
        }

        if (searchResults.size() > 0) {
            searchResult = searchResults.get(0).text().split(" ")[0];
        }

        // When the result is more than 1000 we get 1000+, so we delete the + sign
        if (searchResult.endsWith("+")) {
            searchResult = searchResult.substring(0, searchResult.length() - 1);
        }

        try {
            // We deal with results like 'Zero' or 'Sorry, none job...'
            occurences = Integer.parseInt(searchResult.replace(",", ""));
        } catch (NumberFormatException e) {
            System.out.println("Error parsing:" + searchResult);
            occurences = 0;
        }

        return occurences;
    }
}
