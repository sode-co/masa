package com.devlogs.masa_backend.platform;

import com.devlogs.masa_backend.domain.entities.MeetingPlatform;

import javax.inject.Inject;
import java.net.URL;

public class PlatformCheckerImp implements PlatformChecker {


    @Inject
    public PlatformCheckerImp() {
    }

    public boolean isValidUrl(String url)
    {
        try {
            new URL(url).toURI();
            return true;
        }

        catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean isValid(MeetingPlatform.PLATFORM platform, String url) {
        if (!isValidUrl(url)) return false;

        if (platform != MeetingPlatform.PLATFORM.ZOOM || platform != MeetingPlatform.PLATFORM.GOOGLE_MEET) {
            return false;
        }

        if (platform == MeetingPlatform.PLATFORM.GOOGLE_MEET) {
            if (!url.contains("meet.google.com")) {
                return false;
            }
        }

        if (platform == MeetingPlatform.PLATFORM.ZOOM) {
            if (!url.contains("zoom.us")) {
                return false;
            }
        }
        return true;
    }
}
