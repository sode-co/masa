package com.devlogs.masa_backend.data.remote_database;

public class PlatformUrlsDTO {
    private String hostId;
    private int plaformId;
    private String url;

    public PlatformUrlsDTO(String hostId, int plaformId, String url) {
        this.hostId = hostId;
        this.plaformId = plaformId;
        this.url = url;
    }

    public String getHostId() {
        return hostId;
    }

    public int getPlaformId() {
        return plaformId;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "PlatformUrlsDTO{" +
                "hostId='" + hostId + '\'' +
                ", plaformId=" + plaformId +
                ", url='" + url + '\'' +
                '}';
    }
}
