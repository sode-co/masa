package com.devlogs.masa_backend.repository.meeting_platform;

import com.devlogs.masa_backend.data.remote_database.PlatformUrlsDAO;
import com.devlogs.masa_backend.data.remote_database.PlatformUrlsDTO;
import com.devlogs.masa_backend.domain.entities.MeetingPlatform;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.ports.PlatformRepository;

import javax.inject.Inject;
import java.sql.SQLException;

public class MeetingPlatformRepositoryImp implements PlatformRepository {
    private PlatformUrlsDAO dao;

    @Inject
    public MeetingPlatformRepositoryImp(PlatformUrlsDAO dao) {
        this.dao = dao;
    }

    @Override
    public MeetingPlatform getPlatform(String userId, MeetingPlatform.PLATFORM platform) throws ConnectionException {
        int platformId = 0;

        switch (platform) {
            case GOOGLE_MEET: {
                platformId = 1;
                break;
            }
            case ZOOM: {
                platformId = 2;
                break;
            }
            default: {
                throw new RuntimeException("Your platform: " + platform.name() + " is not supported");
            }
        }

        try {
            PlatformUrlsDTO dto = dao.getUrl(userId, platformId);
            return new MeetingPlatform(platform, userId, dto.getUrl());
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new ConnectionException(e.getMessage());
        }
    }

    @Override
    public void addPlatform(MeetingPlatform platform) throws ConnectionException {
        int platformId = 0;

        switch (platform.getPlatform()) {
            case GOOGLE_MEET: {
                platformId = 1;
                break;
            }
            case ZOOM: {
                platformId = 2;
                break;
            }
            default: {
                throw new RuntimeException("Your platform: " + platform.getPlatform().name() + " is not supported");
            }
        }
        try {
            dao.addNewPlatformUrl(platform.getMentorId(), platformId, platform.getUrl());
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new ConnectionException(e.getMessage());
        }
    }
}
