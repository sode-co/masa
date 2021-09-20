package com.devlogs.masa_backend.data.mock;

import com.devlogs.masa_backend.domain.entities.MeetingPlatform;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.errors.NotFoundException;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class MockMeetingPlatformDataSource {
    public static ArrayList<MeetingPlatform> datas = new ArrayList<>();

    static  {
        datas.add(new MeetingPlatform(MeetingPlatform.PLATFORM.GOOGLE_MEET, "12345", "https://meet.google.com/jsg-rqjg-ybi"));
        datas.add(new MeetingPlatform(MeetingPlatform.PLATFORM.ZOOM, "123457", "https://us05web.zoom.us/j/83708124951?pwd=MWhKNC9KWlZMa21kaTBEMXR0dGdpdz09"));
        datas.add(new MeetingPlatform(MeetingPlatform.PLATFORM.GOOGLE_MEET, "1234", "https://meet.google.com/spi-addt-gsk"));
        datas.add(new MeetingPlatform(MeetingPlatform.PLATFORM.ZOOM, "12354", "https://us05web.zoom.us/j/83708124951?pwd=MWhKNC9KWlZMa21kaTBEMXR0dGdpdz08"));
    }

    public String getMeetingUrl(String mentorId, MeetingPlatform.PLATFORM platform) throws NotFoundException, ConnectionException {
        AtomicReference<String> url = new AtomicReference<>("");
        MockMeetingPlatformDataSource.datas.forEach(l -> {
            if (l.getMentorId().equals(mentorId) && l.getPlatform() == platform) {
                url.set(l.getUrl());
            }
        });
        return url.get();
    }

    @Inject
    public MockMeetingPlatformDataSource( ) {
            }
}
