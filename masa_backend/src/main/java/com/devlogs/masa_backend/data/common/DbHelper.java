package com.devlogs.masa_backend.data.common;

import com.devlogs.masa_backend.common.helper.MasaLog;
import io.github.cdimascio.dotenv.Dotenv;
import org.apache.commons.dbcp.BasicDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DbHelper {
    private BasicDataSource dataSource = null;
    public String DB_URL;
    private String DB_USER;
    private String DB_PASSWORD;

    public DbHelper (String realPath) {
        Dotenv env = Dotenv.configure().directory(realPath+"/env/.env").ignoreIfMalformed().ignoreIfMissing().load();
        DB_USER = env.get("DATABASE_USER");
        DB_PASSWORD = env.get("DATABASE_PASSWORD");
        String DB_NAME = env.get("DATABASE_NAME");
        String DB_HOST = env.get("DATABASE_HOST");
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
