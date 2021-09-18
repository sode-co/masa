package com.devlogs.masa_backend.repository.meeting;

import com.devlogs.masa_backend.domain.entities.MeetingPlatform;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.errors.NotFoundException;
import com.devlogs.masa_backend.domain.ports.MeetingPlatformRepository;

public class MeetingPlatformRepositoryImp implements MeetingPlatformRepository {
    @Override
    public String getMeetingUrl(String mentorId, MeetingPlatform.PLATFORM platform) throws NotFoundException, ConnectionException {
        return null;
    }
}
