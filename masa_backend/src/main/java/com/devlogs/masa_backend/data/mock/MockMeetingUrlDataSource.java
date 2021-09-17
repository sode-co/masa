package com.devlogs.masa_backend.data.mock;

import com.devlogs.masa_backend.domain.entities.MeetingPlatform;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;

public class MockMeetingUrlDataSource {
    public static ArrayList<MeetingPlatform> datas = new ArrayList<>();

    static  {
        datas.add(new MeetingPlatform(MeetingPlatform.PLATFORM.GOOGLE_MEET, "12345", "https://meet.google.com/jsg-rqjg-ybi"));
        datas.add(new MeetingPlatform(MeetingPlatform.PLATFORM.ZOOM, "12345", "https://us05web.zoom.us/j/83708124951?pwd=MWhKNC9KWlZMa21kaTBEMXR0dGdpdz09"));
        datas.add(new MeetingPlatform(MeetingPlatform.PLATFORM.GOOGLE_MEET, "1234", "https://meet.google.com/spi-addt-gsk"));
        datas.add(new MeetingPlatform(MeetingPlatform.PLATFORM.ZOOM, "1234", "https://us05web.zoom.us/j/83708124951?pwd=MWhKNC9KWlZMa21kaTBEMXR0dGdpdz08"));
    }

    @Inject
    public MockMeetingUrlDataSource( ) {
            }
}
