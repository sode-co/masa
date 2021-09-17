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
    public static ArrayList<MeetingEntity> meetings = new ArrayList<>();
    public static final long day = 24 * 60 * 60 *1000;
    public static final long oneHour = day/24;
    public static final long hafDay = day/2;

    static {
        ArrayList<UserEntity> users = new MockUserDataSource().data;
        users.forEach(u -> {
            long startTime = System.currentTimeMillis() - new Random().nextLong();
            meetings.add(
                    new MeetingEntity(System.currentTimeMillis() + "", "Devlogs Talkshows",
                            new MeetingPlatform(MeetingPlatform.PLATFORM.GOOGLE_MEET, u.getId(),
                                    "https://meet.google.com/spi-addt-gsk"),u,startTime,startTime + hafDay, "Xin chào, vào đây nói chuyện với mình nheeee" ));
            long startTime2 = System.currentTimeMillis() - new Random().nextLong();
            meetings.add(
                    new MeetingEntity(System.currentTimeMillis() + "", "Sode talkshows",
                            new MeetingPlatform(MeetingPlatform.PLATFORM.ZOOM, u.getId(),
                                    "https://meet.google.com/jsg-rqjg-ybi"),u,startTime, startTime + oneHour, "Xin chào, vào đây nói chuyện với mình nheeee" ));
        });
    }

    @Inject
    public MockMeetingDataSource () {

    }
}
