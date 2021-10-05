package com.devlogs.masa_backend.repository.meeting;

import com.devlogs.masa_backend.data.remote_database.*;
import com.devlogs.masa_backend.domain.entities.MeetingEntity;
import com.devlogs.masa_backend.domain.entities.MeetingPlatform;
import com.devlogs.masa_backend.domain.entities.TopicEntity;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.errors.NotFoundException;
import com.devlogs.masa_backend.domain.ports.MeetingRepository;
import javax.inject.Inject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MeetingRepositoryImp implements MeetingRepository {

    private MeetingDAO meetingSource;
    private PlatformUrlsDAO meetingPlatformUrlSource;
    private TopicDAO topicSource;

    @Inject
    public MeetingRepositoryImp(MeetingDAO meetingSource, PlatformUrlsDAO meetingPlatformUrlSource, TopicDAO topicSource) {
        this.meetingSource = meetingSource;
        this.meetingPlatformUrlSource = meetingPlatformUrlSource;
        this.topicSource = topicSource;
    }

    public MeetingEntity toMeetingEntity(MeetingDTO meetingDTO) throws SQLException,ClassNotFoundException{
        MeetingEntity meeting = null;
        PlatformUrlsDTO platformUrlsDTO = meetingPlatformUrlSource.getUrl(meetingDTO.getHost_id(), meetingDTO.getPlatform_id());
        TopicDTO topicDTO = topicSource.getTopicByID(meetingDTO.getTopic_id());
        if (platformUrlsDTO == null) {
            throw new RuntimeException("Platform urls not found");
        }
        if (topicDTO == null) {
            throw new RuntimeException("Topic not found");
        }

        TopicEntity topic = topicEntity(topicDTO);
        MeetingPlatform platform = toPlatform(meetingDTO.getPlatform_id(), platformUrlsDTO.getHostId(),platformUrlsDTO.getUrl());

        if (platform!=null && topic!=null){
            meeting = new MeetingEntity(meetingDTO.getId(),meetingDTO.getTitle(),platform,topic,meetingDTO.getHost_id(),
                    meetingDTO.getStartTime(),meetingDTO.getEndTime(),meetingDTO.getDescription());
        }
        return meeting;
    }

    public TopicEntity topicEntity(TopicDTO dto){
        return new TopicEntity(dto.getId(), dto.getTitle());
    }

    public MeetingPlatform toPlatform(int id,String host_id, String url){
        MeetingPlatform platform = null;
        switch (id){
            case 1:
                platform = new MeetingPlatform(MeetingPlatform.PLATFORM.GOOGLE_MEET,host_id,url);
                break;
            case 2:
                platform = new MeetingPlatform(MeetingPlatform.PLATFORM.ZOOM,host_id,url);
                break;
        }
        return platform;
    }

    @Override
    public List<MeetingEntity> getAll() throws ConnectionException {
        List<MeetingEntity> result = null;
        try{
            //get data from DAO
            List<MeetingDTO> listDTO = meetingSource.getAllMeetings();
            if (listDTO != null) {
                if(result == null){
                    result = new ArrayList<>();
                }
                for(MeetingDTO dto:listDTO){
                    result.add(toMeetingEntity(dto));
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            throw new ConnectionException(ex.getMessage());
        }
        return result;
    }

    @Override
    public List<MeetingEntity> getByHostId(String hostId) throws ConnectionException {
        List<MeetingEntity> result = new ArrayList<>();
        try{
            //get data from DAO
            List<MeetingDTO> listDTO = meetingSource.getMeetingsByHost(hostId);
            if (listDTO != null) {
                for(MeetingDTO dto:listDTO){
                    result.add(toMeetingEntity(dto));
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            throw new ConnectionException(ex.getMessage());
        }
        return result;
    }

    @Override
    public MeetingEntity create(String title, MeetingPlatform.PLATFORM platform, String hostId, TopicEntity topic, long startTime, long endTime, String description) throws ConnectionException {
        MeetingEntity meeting = null;
        try{
            int platformId = 0;
            if(platform.toString().equals("GOOGLE_MEET")){
                platformId = 1;
            }else{
                platformId=2;
            }
            String id = System.currentTimeMillis()+"";
            MeetingDTO dto = meetingSource.createMeeting(id,title,platformId,hostId,1,topic.getId(),startTime,endTime,description);
            if(dto!=null){
                meeting = toMeetingEntity(dto);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            throw new ConnectionException(ex.getMessage());
        }
        return meeting;
    }

    @Override
    public List<MeetingEntity> getFollowedMeetings(String userId) throws ConnectionException {
        List<MeetingEntity> result = new ArrayList<>();
        try{
            //get data from DAO
            List<MeetingDTO> listDTO = meetingSource.getUserFollowedMeetings(userId);
            if (listDTO != null) {
                for (MeetingDTO dto : listDTO) {
                    result.add(toMeetingEntity(dto));
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            throw new ConnectionException(ex.getMessage());
        }
        return result;
    }

    @Override
    public List<MeetingEntity> getNotFollowedMeetings(String userId) throws ConnectionException {
        List<MeetingEntity> result = new ArrayList<>();
        try{
            //get data from DAO
            List<MeetingDTO> listDTO = meetingSource.getUserNotFollowedMeetings(userId);
            if (listDTO != null) {
                for(MeetingDTO dto:listDTO){
                    result.add(toMeetingEntity(dto));
                }//end traversed listDTO
            }//end if listDTO existed
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            throw new ConnectionException(ex.getMessage());
        }
        return result;
    }

    @Override
    public MeetingEntity updateMeeting(String meetingId, String title, MeetingPlatform.PLATFORM platform, long startTime, long endTime, String description) throws ConnectionException, NotFoundException {
        MeetingEntity meeting = null;
        try{
            int platformId = 0;
            if(platform.toString().equals("GOOGLE_MEET")){
                platformId = 1;
            }else{
                platformId=2;
            }
            MeetingDTO dto = meetingSource.updateMeeting(meetingId,title,platformId,startTime,endTime,description);
            if(dto!=null){
                meeting = toMeetingEntity(dto);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            throw new ConnectionException(ex.getMessage());
        }
        return meeting;
    }

    @Override
    public MeetingEntity getById(String meetingId) throws ConnectionException {
        MeetingEntity result = null;
        try{
            //get data from DAO
            MeetingDTO dto = meetingSource.getMeetingByID(meetingId);
            if (dto != null) {
                    result = toMeetingEntity(dto);
            }//end if DTO existed
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            throw new ConnectionException(ex.getMessage());
        }
        return result;
    }

}
