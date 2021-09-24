package com.devlogs.masa_backend.data.remote_database;

import com.devlogs.masa_backend.data.common.DbHelper;

import javax.inject.Inject;
import java.sql.*;

public class PlatformUrlsDAO {

    private DbHelper dbHelper;

    @Inject
    public PlatformUrlsDAO(DbHelper dbHelper) {
        this.dbHelper = dbHelper;
    }

    public PlatformUrlsDTO getUrl(String hostId, int platformId) throws SQLException, ClassNotFoundException {
        try (Connection con = dbHelper.connect()) {
            PreparedStatement ctm = con.prepareStatement("SELECT url FROM PlatformUrls WHERE mentor_id=? AND platform_id=?;");
            ctm.setString(1, hostId);
            ctm.setInt(2, platformId);
            ResultSet rs = ctm.executeQuery();
            if (rs.next()) {
                String url = rs.getString(1);
                return new PlatformUrlsDTO(hostId, platformId, url);
            }
        }
        return null;
    }

    public PlatformUrlsDTO addNewPlatformUrl(String hostId, int platformId, String url) throws SQLException, ClassNotFoundException {
        try (Connection con = dbHelper.connect()) {
            PreparedStatement ctm = con.prepareStatement("INSERT INTO PlatformUrls(mentor_id,platform_id,url) VALUES (?,?,?);");
            ctm.setString(1, hostId);
            ctm.setInt(2, platformId);
            ctm.setString(3, url);
            int result = ctm.executeUpdate();
            if (result > 0) {
                return new PlatformUrlsDTO(hostId, platformId, url);
            }
        }
        return null;
    }
}
