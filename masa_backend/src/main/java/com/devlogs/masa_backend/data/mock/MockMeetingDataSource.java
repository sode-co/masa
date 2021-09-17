package com.devlogs.masa_backend.data.mock;

import com.devlogs.masa_backend.domain.entities.MeetingEntity;
import com.devlogs.masa_backend.domain.entities.MeetingPlatform;
import com.devlogs.masa_backend.domain.entities.UserEntity;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Random;

/*
* https://meet.google.com/jsg-rqjg-ybi
* https://meet.google.com/spi-addt-gsk
* */
public class MockMeetingDataSource {
    public ArrayList<MeetingEntity> meetings = new ArrayList<>();
    public final long day = 24 * 60 * 60 *1000;
    public final long oneHour = day/24;
    public final long hafDay = day/2;
    @Inject
    public MockMeetingDataSource () {
        ArrayList<UserEntity> users = new MockUserDataSource().data;
        users.forEach(u -> {
            long startTime = System.currentTimeMillis() - new Random().nextLong();
            meetings.add(
                    new MeetingEntity(System.currentTimeMillis() + "", "Devlogs Talkshows",
                    new MeetingPlatform(MeetingPlatform.PLATFORM.GOOGLE_MEET,
                    "https://meet.google.com/spi-addt-gsk"),u,startTime,startTime + hafDay, "Xin chào, vào đây nói chuyện với mình nheeee" ));
            long startTime2 = System.currentTimeMillis() - new Random().nextLong();
            meetings.add(
                    new MeetingEntity(System.currentTimeMillis() + "", "Sode talkshows",
                            new MeetingPlatform(MeetingPlatform.PLATFORM.ZOOM,
                                    "https://meet.google.com/jsg-rqjg-ybi"),u,startTime, startTime + oneHour, "Xin chào, vào đây nói chuyện với mình nheeee" ));
        });
    }
}
