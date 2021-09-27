package com.devlogs.masa_backend.domain.ports;

import com.devlogs.masa_backend.domain.entities.MeetingPlatform;
import com.devlogs.masa_backend.domain.errors.ConnectionException;

public interface PlatformRepository {
    MeetingPlatform getPlatform(String userId, MeetingPlatform.PLATFORM platform) throws ConnectionException;

    public void addPlatform (MeetingPlatform platform) throws ConnectionException;
}
