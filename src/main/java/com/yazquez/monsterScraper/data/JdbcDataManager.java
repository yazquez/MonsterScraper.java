package com.yazquez.monsterScraper.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import com.yazquez.monsterScraper.entities.SearchEntity;

public class JdbcDataManager implements DataManager {

    List<SearchEntity> searchs = SearchConfigurationManager.getSearchs();
    private DataSource dataSource;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<SearchEntity> getSearchs() {
        // TODO Auto-generated method stub
        return searchs;
    }

    @Override
    public void saveResults() {
        String insertLaunchSql = "insert into launchs(date, host, configuration) values (?,?,?)";
        String insertSearchSql = "insert into results(date, country, city, technology, occurences) values (?,?,?,?,?)";
        Connection conn = null;
        try {
            conn = dataSource.getConnection();

            PreparedStatement psLauch = conn.prepareStatement(insertLaunchSql);

            psLauch.setDate(1, new java.sql.Date(new Date().getTime()));
            psLauch.setString(2, SearchConfigurationManager.getHostname());
            psLauch.setString(3, SearchConfigurationManager.getConfiguration().toString());

            psLauch.executeUpdate();
            psLauch.close();

            PreparedStatement psSearchs = conn.prepareStatement(insertSearchSql);
            for (SearchEntity search : this.getSearchs()) {
                Date date = new SimpleDateFormat("yyyy/MM/dd").parse(search.getDate());
                psSearchs.setDate(1, new java.sql.Date(date.getTime()));
                psSearchs.setString(2, search.getCountry());
                psSearchs.setString(3, search.getCity());
                psSearchs.setString(4, search.getTechnology());
                psSearchs.setInt(5, search.getResult());

                psSearchs.executeUpdate();
            }
            psSearchs.close();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new RuntimeException();
                }
            }
        }
    }

}
