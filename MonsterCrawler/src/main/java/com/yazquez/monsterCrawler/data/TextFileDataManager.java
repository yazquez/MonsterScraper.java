package com.yazquez.monsterCrawler.data;

import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.input.ReversedLinesFileReader;
import org.codehaus.jackson.map.ObjectMapper;

import com.yazquez.monsterCrawler.entities.PlaceEntity;
import com.yazquez.monsterCrawler.entities.SearchConfiguration;
import com.yazquez.monsterCrawler.entities.SearchEntity;

public class TextFileDataManager implements DataManager {

    SearchConfiguration configuration;

    List<SearchEntity> searchs = new ArrayList<SearchEntity>();

    private String configurationFileName;
    private String dataFileName;

    public TextFileDataManager() {
        this.configurationFileName = "file/monsterCrawler-config.json";
        this.dataFileName = "file/monsterCrawler-results.data";

        this.loadConfiguration();
        this.buildSearchList();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.yazquez.monsterCrawler.data.DataManager#getSearchs()
     */
    public List<SearchEntity> getSearchs() {
        return searchs;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.yazquez.monsterCrawler.data.DataManager#saveSearchs()
     */
    public void saveResults() {
        if (currentDateIsNotSaved()) {
            FileWriter fw = null;
            try {
                String lineSeparator = System.getProperty("line.separator");
                fw = new FileWriter(this.dataFileName, true);
                for (SearchEntity search : this.getSearchs()) {
                    fw.write(search.toCsv());
                    fw.write(lineSeparator);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    fw.close();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private void buildSearchList() {
        for (PlaceEntity place : configuration.getPlaces()) {
            for (String technology : configuration.getTechnologies()) {
                searchs.add(new SearchEntity(place.getCountry(), place.getCity(), technology));
            }
        }
    }

    private void loadConfiguration() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            configuration = mapper.readValue(new File(configurationFileName), SearchConfiguration.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private boolean currentDateIsNotSaved() {
        String lastDate = loadLastDateProcessed();
        String currenDate = new SimpleDateFormat("yyyy/MM/dd").format(new Date());

        return !lastDate.equals(currenDate);
    }

    private String loadLastDateProcessed() {
        String lastDate = "";
        try (ReversedLinesFileReader reader = new ReversedLinesFileReader(new File(this.dataFileName))) {
            String line;
            line = reader.readLine();
            if (line != null) {
                lastDate = line.split(",")[0];
            }
            return lastDate;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
