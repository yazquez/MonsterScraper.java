package com.yazquez.monsterCrawler.entities;

import java.util.ArrayList;
import java.util.List;

public class SearchConfiguration {

    private List<PlaceEntity> places = new ArrayList<PlaceEntity>();
    private List<String> technologies = new ArrayList<String>();

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Tecnologies:[ ");
        for (String technology : getTechnologies()) {
            result.append(technology);
            result.append(" ");
        }

        result.append("] - ");
        result.append("Places : [");

        for (PlaceEntity place : getPlaces()) {
            result.append(place);
            result.append(" ");
        }

        return result.toString();
    }

    public List<String> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<String> technologies) {
        this.technologies = technologies;
    }

    public List<PlaceEntity> getPlaces() {
        return places;
    }

    public void setPlaces(List<PlaceEntity> places) {
        this.places = places;
    }
}
