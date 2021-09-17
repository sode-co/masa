package com.devlogs.masa_backend.data.common;

import io.github.cdimascio.dotenv.Dotenv;
import org.apache.commons.dbcp.BasicDataSource;

import javax.inject.Inject;
import java.sql.Connection;
import java.sql.SQLException;

public class DbHelper {
    private BasicDataSource dataSource = null;
    public String DB_URL;
    private String DB_USER;
    private String DB_PASSWORD;

    public DbHelper (String envFilePath) {
        Dotenv env = Dotenv.configure().directory(envFilePath+"/env/masa.env").ignoreIfMalformed().ignoreIfMissing().load();
        DB_USER = env.get("DATABASE_USER");
        assert (DB_USER != null);
        DB_PASSWORD = env.get("DATABASE_PASSWORD");
        assert (DB_PASSWORD != null);
        String DB_NAME = env.get("DATABASE_NAME");
        assert (DB_NAME != null);
        String DB_HOST = env.get("DATABASE_HOST");
        assert (DB_HOST != null);
        DB_URL = "jdbc:mysql://" + DB_HOST + "/" + DB_NAME;
    }

    public Connection connect () throws ClassNotFoundException, SQLException {
        if (dataSource == null) {
            Class.forName("com.mysql.jdbc.Driver");
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
