package com.devlogs.masa_backend.data.common;

import com.devlogs.masa_backend.common.Masa;
import org.apache.commons.dbcp.BasicDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DbHelper {
    private BasicDataSource dataSource = null;
    public String DB_URL;
    private String DB_USER;
    private String DB_PASSWORD;

    public DbHelper () {
        DB_USER = Masa.DATABASE_USER;
        DB_PASSWORD = Masa.DATABASE_PASSWORD;
        String DB_NAME = Masa.DATABASE_NAME;
        String DB_HOST = Masa.DATABASE_HOST;
        DB_URL = "jdbc:sqlserver://" + DB_HOST + ";DatabaseName=" + DB_NAME;
    }

    public Connection connect () throws ClassNotFoundException, SQLException {
        if (dataSource == null) {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            dataSource = new BasicDataSource();
            dataSource.setUrl(DB_URL);
            dataSource.setUsername(DB_USER);
            dataSource.setPassword(DB_PASSWORD);
            dataSource.setMinIdle(5);
            dataSource.setMaxIdle(10);
        }
        return dataSource.getConnection();
    }
}
