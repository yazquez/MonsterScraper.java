package com.yazquez.monsterScraper.data;

import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.input.ReversedLinesFileReader;

import com.yazquez.monsterScraper.entities.SearchEntity;

public class TextFileDataManager implements DataManager {
    List<SearchEntity> searchs = SearchConfigurationManager.getSearchs();

    private String dataFileName;

    public TextFileDataManager() {
        this.dataFileName = "file/monsterScraper-results.data";
    }

    public List<SearchEntity> getSearchs() {
        return searchs;
    }

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
