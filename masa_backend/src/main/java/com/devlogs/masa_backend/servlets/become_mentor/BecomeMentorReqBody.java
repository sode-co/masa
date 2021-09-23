package com.devlogs.masa_backend.servlets.become_mentor;

import com.devlogs.masa_backend.domain.entities.MeetingPlatform;
import com.devlogs.masa_backend.platform.PlatformChecker;
import com.devlogs.masa_backend.platform.PlatformCheckerImp;

import javax.validation.constraints.NotBlank;

public class BecomeMentorReqBody {
    @NotBlank (message = "Your description can not be empty")
    private String description;
    @NotBlank (message = "Your Zoom trl can not be empty")
    private String zoomUrl;
    @NotBlank (message = "Your Google meet url can not be empty")
    private String googleMeetUrl;

    public BecomeMentorReqBody () {}

    public BecomeMentorReqBody(String description, String zoomUrl, String googleMeetUrl) {
        this.description = description;
        this.zoomUrl = zoomUrl;
        this.googleMeetUrl = googleMeetUrl;
    }

    public boolean isValidUrl () {
        return new PlatformCheckerImp().isValid(MeetingPlatform.PLATFORM.GOOGLE_MEET, googleMeetUrl)
               &&
                new PlatformCheckerImp().isValid(MeetingPlatform.PLATFORM.ZOOM, zoomUrl);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getZoomUrl() {
        return zoomUrl;
    }

    public void setZoomUrl(String zoomUrl) {
        this.zoomUrl = zoomUrl;
    }

    public String getGoogleMeetUrl() {
        return googleMeetUrl;
    }

    public void setGoogleMeetUrl(String googleMeetUrl) {
        this.googleMeetUrl = googleMeetUrl;
    }
}
