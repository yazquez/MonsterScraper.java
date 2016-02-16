package com.yazquez.monsterCrawler.data;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class TextFileDataManagerTest {

    static TextFileDataManager dataManager = new TextFileDataManager();

    @Test
    public void shouldLoadTechnologies() {
        List<String> technologies = dataManager.technologies;
        assertTrue(String.format("The number of technologies loaded is not correct. Expected [6] loaded [%s]",
                technologies.size()), technologies.size() == 6);
        assertTrue("Hadoop technology not loaded", !technologies.contains("hadoop"));
        assertTrue("Angular technology not loaded", !technologies.contains("angular"));
    }
}
