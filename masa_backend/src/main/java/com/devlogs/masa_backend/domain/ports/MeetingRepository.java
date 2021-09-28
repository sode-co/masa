package com.devlogs.masa_backend.domain.ports;

import com.devlogs.masa_backend.domain.entities.MeetingEntity;
import com.devlogs.masa_backend.domain.entities.MeetingPlatform;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.errors.NotFoundException;

import java.sql.SQLException;
import java.util.List;

public interface MeetingRepository {
    List<MeetingEntity> getAll() throws ConnectionException;

    List<MeetingEntity> getByHostId(String hostId) throws ConnectionException;

    MeetingEntity create(String title, MeetingPlatform.PLATFORM platform, String hostId, long startTime, long endTime, String description) throws ConnectionException;

    MeetingEntity updateMeeting(String meetingId, String title, MeetingPlatform.PLATFORM platform, long startTime, long endTime, String description) throws ConnectionException, NotFoundException;

    MeetingEntity getById(String meetingId) throws ConnectionException;

    List<MeetingEntity> getFollowedMeetings(String userId) throws ConnectionException;
}