package com.devlogs.masa_backend.repository.mock;

import com.devlogs.masa_backend.data.mock.MockMeetingDataSource;
import com.devlogs.masa_backend.domain.entities.MeetingEntity;
import com.devlogs.masa_backend.domain.entities.MeetingPlatform;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.errors.HostDoesNotExistException;
import com.devlogs.masa_backend.domain.errors.NotFoundException;
import com.devlogs.masa_backend.domain.ports.MeetingRepository;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class MockMeetingRepositoryImp implements MeetingRepository {

    private MockMeetingDataSource dataSource;
    private MockUserRepositoryImp userDataSource;
    private MockMeetingPlatformRepositoryImp mockMeetingPlatformRepositoryImp;

    @Inject
    public MockMeetingRepositoryImp (MockMeetingDataSource dataSource, MockUserRepositoryImp userDataSource, MockMeetingPlatformRepositoryImp mockMeetingPlatformRepositoryImp) {
        this.dataSource = dataSource;
        this.userDataSource = userDataSource;
        this.mockMeetingPlatformRepositoryImp = mockMeetingPlatformRepositoryImp;
    }

    @Override
    public List<MeetingEntity> getAll() throws ConnectionException {
        return dataSource.meetings;
    }

    @Override
    public List<MeetingEntity> getByHostId(String hostId) throws ConnectionException {
        ArrayList<MeetingEntity> results = new ArrayList<>();
        dataSource.meetings.forEach(u -> {
            if (u.getHost().equals(hostId)) {
                results.add(u);
            }
        });
        return results;
    }

    @Override
    public MeetingEntity create(String title, MeetingPlatform.PLATFORM platform, String hostId, long startTime, long endTime, String description) throws ConnectionException {
        try {
        MeetingEntity meetingEntity =
                null;
            meetingEntity = new MeetingEntity(System.currentTimeMillis() + "", title,
                   new MeetingPlatform(platform,hostId, mockMeetingPlatformRepositoryImp.getMeetingUrl(hostId, platform)),userDataSource.getUserById(hostId),startTime,endTime, description);
            return meetingEntity;
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public MeetingEntity updateMeeting(String meetingId, String title, MeetingPlatform platform, long startTime, long endTime, String description) throws ConnectionException, NotFoundException {
        return null;
    }
}
