package com.devlogs.masa_backend.repository.mock;

import com.devlogs.masa_backend.data.mock.MockMeetingUrlDataSource;
import com.devlogs.masa_backend.domain.entities.MeetingPlatform;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.errors.NotFoundException;
import com.devlogs.masa_backend.domain.ports.MeetingPlatformRepository;

import javax.inject.Inject;
import java.util.concurrent.atomic.AtomicReference;

public class MockMeetingPlatformRepositoryImp implements MeetingPlatformRepository {
    private MockMeetingUrlDataSource dataSource;

    @Inject
    public MockMeetingPlatformRepositoryImp(MockMeetingUrlDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public String getMeetingUrl(String mentorId, MeetingPlatform.PLATFORM platform) throws NotFoundException, ConnectionException {
        AtomicReference<String> url = new AtomicReference<>("");
        dataSource.datas.forEach(l -> {
            if (l.getMentorId().equals(mentorId) && l.getPlatform() == platform) {
                url.set(l.getUrl());
            }
        });
        return url.get();
    }
}
