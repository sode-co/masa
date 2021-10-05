package com.devlogs.masa_backend.repository.mock;

import com.devlogs.masa_backend.common.helper.MasaLog;
import com.devlogs.masa_backend.data.mock.MockMeetingDataSource;
import com.devlogs.masa_backend.data.mock.MockMeetingPlatformDataSource;
import com.devlogs.masa_backend.data.mock.MockUserDataSource;
import com.devlogs.masa_backend.domain.entities.MeetingEntity;
import com.devlogs.masa_backend.domain.entities.MeetingPlatform;
import com.devlogs.masa_backend.domain.entities.TopicEntity;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.errors.NotFoundException;
import com.devlogs.masa_backend.domain.ports.MeetingRepository;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class MockMeetingRepositoryImp implements MeetingRepository {

    private MockMeetingDataSource dataSource;
    private MockUserDataSource userDataSource;
    private MockMeetingPlatformDataSource mockMeetingPlatformDataSource;

    @Inject
    public MockMeetingRepositoryImp (MockMeetingDataSource dataSource, MockUserDataSource userDataSource, MockMeetingPlatformDataSource mockMeetingPlatformDataSource) {
        this.dataSource = dataSource;
        this.userDataSource = userDataSource;
        this.mockMeetingPlatformDataSource = mockMeetingPlatformDataSource;
    }

    @Override
    public List<MeetingEntity> getAll() throws ConnectionException {
        return MockMeetingDataSource.meetings;
    }

    @Override
    public List<MeetingEntity> getByHostId(String hostId) throws ConnectionException {
        ArrayList<MeetingEntity> results = new ArrayList<>();
        MockMeetingDataSource.meetings.forEach(u -> {
            if (u.getHostId().equals(hostId)) {
                results.add(u);
            }
        });
        return results;
    }

    @Override
    public MeetingEntity create(String title, MeetingPlatform.PLATFORM platform, String hostId, TopicEntity topic, long startTime, long endTime, String description) throws ConnectionException {
        return null;
    }


    @Override
    public MeetingEntity updateMeeting(String meetingId, String title, MeetingPlatform.PLATFORM platform, long startTime, long endTime, String description) throws ConnectionException, NotFoundException {
        MeetingEntity updatedMeeting = null;
        for (MeetingEntity meeting : MockMeetingDataSource.meetings) {
            if (meeting.getId().equals(meetingId)) {
                updatedMeeting = meeting;
                meeting.setDescription(description);
                if (meeting.getPlatform().getPlatform() != platform) {
                    String url = mockMeetingPlatformDataSource.getMeetingUrl(meeting.getHostId(), platform);
                    meeting.setPlatform(new MeetingPlatform(platform, meeting.getHostId(), url));
                }
                meeting.setTitle(title);
                meeting.setEndTime(endTime);
                meeting.setStartTime(startTime);
            }
        }
        if (updatedMeeting == null) {
            throw new NotFoundException("Can not find any meeting with id: " + meetingId);
        }
        return updatedMeeting;
    }

    @Override
    public MeetingEntity getById(String meetingId) throws ConnectionException {
        for (MeetingEntity meeting : MockMeetingDataSource.meetings) {
            if (meeting.getId().equals(meetingId)) {
                return meeting;
            }
        }
            return null;
    }

    @Override
    public List<MeetingEntity> getFollowedMeetings(String userId) throws ConnectionException {


        return null;
    }

    @Override
    public List<MeetingEntity> getNotFollowedMeetings(String userId) throws ConnectionException {
        return null;
    }
}
