package com.devlogs.masa_backend.platform;

import com.devlogs.masa_backend.domain.entities.MeetingPlatform;

public interface PlatformChecker {

    boolean isValid (MeetingPlatform.PLATFORM platform, String url);

}
