package com.devlogs.masa_backend.servlets.meeting.common;

import com.devlogs.masa_backend.domain.entities.MeetingPlatform;
import com.devlogs.masa_backend.domain.entities.TopicEntity;
import com.devlogs.masa_backend.domain.entities.UserEntity;

import java.util.List;

public class GetMeetingResponse {
    public static class Data {
        public String id;
        public String title;
        public MeetingPlatform platform;
        public TopicEntity topic;
        public UserEntity mentor;
        public long startTime;
        public long endTime;
        public String description;

        public Data () {

        }

        public Data(String id, String title, MeetingPlatform platform, TopicEntity topic, UserEntity mentor, long startTime, long endTime, String description) {
            this.id = id;
            this.title = title;
            this.platform = platform;
            this.topic = topic;
            this.mentor = mentor;
            this.startTime = startTime;
            this.endTime = endTime;
            this.description = description;
        }
    }

    public List<Data> meetings;

    public GetMeetingResponse () {}

    public GetMeetingResponse(List<Data> meetings) {
        this.meetings = meetings;
    }
}