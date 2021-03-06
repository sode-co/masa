package com.devlogs.masa_backend.domain.ports;

import com.devlogs.masa_backend.domain.entities.MeetingEntity;
import com.devlogs.masa_backend.domain.entities.MeetingPlatform;
import com.devlogs.masa_backend.domain.entities.TopicEntity;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.errors.NotFoundException;

import java.util.List;

public interface MeetingRepository {
    List<MeetingEntity> getAll() throws ConnectionException;

    List<MeetingEntity> getByHostId(String hostId) throws ConnectionException;

    MeetingEntity create(String title, MeetingPlatform.PLATFORM platform, String hostId, TopicEntity topic, long startTime, long endTime, String description) throws ConnectionException;

    List<MeetingEntity> getMeetingsByTime(long from, long to) throws ConnectionException;

    List<MeetingEntity> getMeetingsByTopic(int topicId) throws ConnectionException;

    MeetingEntity updateMeeting(String meetingId, String title, MeetingPlatform.PLATFORM platform, long startTime, long endTime, String description) throws ConnectionException, NotFoundException;

    MeetingEntity getById(String meetingId) throws ConnectionException;

    List<MeetingEntity> getFollowedMeetings(String userId) throws ConnectionException;

    List<MeetingEntity> getNotFollowedMeetings(String userId) throws ConnectionException;


    List<MeetingEntity> getNewMeetings() throws ConnectionException;

    List<MeetingEntity> getMeetingsByTitle(String title) throws ConnectionException;

    List<MeetingEntity> getMeetingsByHostName(String hostName) throws ConnectionException;

    MeetingEntity updateMeetingStatus(String meetingId) throws ConnectionException,NotFoundException;

    List<MeetingEntity> getAllActiveMeetings() throws ConnectionException;

    List<MeetingEntity> getOnGoingMeetings() throws ConnectionException;

    int countAllGoingMeetingsInWeek() throws ConnectionException;

    int countAllCreatedMeetingsInWeek() throws ConnectionException;

    int countAllActiveMeetings() throws ConnectionException;

    int countNumOfUserFollowedMeetingInWeek() throws ConnectionException;
}