package com.yazquez.monsterScraper.data;

import java.io.File;

import org.codehaus.jackson.map.ObjectMapper;

import com.yazquez.monsterScraper.entities.SearchConfiguration;

public class SearchConfigurationManager {

    private static String configurationFileName = "file/monsterScraper-config.json";

    public static SearchConfiguration loadConfiguration() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new File(configurationFileName), SearchConfiguration.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
