package com.devlogs.masa_backend.domain.ports;

import com.devlogs.masa_backend.domain.entities.MeetingPlatform;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.errors.NotFoundException;

public interface MeetingPlatformRepository {
     String getMeetingUrl (String mentorId, MeetingPlatform.PLATFORM platform) throws NotFoundException, ConnectionException;
}
