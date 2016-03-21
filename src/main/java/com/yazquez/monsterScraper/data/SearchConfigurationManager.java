package com.yazquez.monsterScraper.data;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

import com.yazquez.monsterScraper.entities.PlaceEntity;
import com.yazquez.monsterScraper.entities.SearchConfiguration;
import com.yazquez.monsterScraper.entities.SearchEntity;

public class SearchConfigurationManager {

    private static String configurationFileName = "file/monsterScraper-config.json";
    private static SearchConfiguration configuration = loadConfiguration();

    public static SearchConfiguration loadConfiguration() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new File(configurationFileName), SearchConfiguration.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static List<SearchEntity> getSearchs() {
        List<SearchEntity> searchs = new ArrayList<SearchEntity>();
        for (PlaceEntity place : configuration.getPlaces()) {
            for (String technology : configuration.getTechnologies()) {
                searchs.add(new SearchEntity(place.getCountry(), place.getCity(), technology));
            }
        }
        return searchs;
    }

    public static String getHostname() {
        String hostname = "Unknown";

        try {
            InetAddress addr;
            addr = InetAddress.getLocalHost();
            hostname = addr.getHostName();
        } catch (UnknownHostException ex) {
            System.out.println("Hostname can not be resolved");
        }
        return hostname;
    }

    public static SearchConfiguration getConfiguration() {
        return configuration;
    }
}
