package com.devlogs.masa_backend.repository.meeting;

import com.devlogs.masa_backend.data.remote_database.MeetingDAO;
import com.devlogs.masa_backend.data.remote_database.MeetingDTO;
import com.devlogs.masa_backend.data.remote_database.PlatformUrlsDAO;
import com.devlogs.masa_backend.data.remote_database.PlatformUrlsDTO;
import com.devlogs.masa_backend.domain.entities.MeetingEntity;
import com.devlogs.masa_backend.domain.entities.MeetingPlatform;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.errors.NotFoundException;
import com.devlogs.masa_backend.domain.ports.MeetingRepository;
import com.devlogs.masa_backend.repository.user.UserRepositoryImp;

import javax.inject.Inject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MeetingRepositoryImp implements MeetingRepository {

    private MeetingDAO meetingSource;
    private PlatformUrlsDAO meetingPlatformUrlSource;

    @Inject
    public MeetingRepositoryImp(MeetingDAO meetingSource, PlatformUrlsDAO meetingPlatformUrlSource) {
        this.meetingSource = meetingSource;
        this.meetingPlatformUrlSource = meetingPlatformUrlSource;
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
                    //get PlatformUrlsDTO
                    PlatformUrlsDTO platformUrlsDTO = meetingPlatformUrlSource.getUrl(dto.getHost_id(), dto.getPlatform_id());
                    MeetingPlatform.PLATFORM platform;
                    result.add(new MeetingEntity(dto.getId(),dto.getTitle(),
                            new MeetingPlatform(MeetingPlatform.PLATFORM.values()[platformUrlsDTO.getPlaformId()-1], dto.getHost_id(),platformUrlsDTO.getUrl()),
                            dto.getHost_id(),dto.getStartTime(),dto.getEndTime(),dto.getDescription()));
                }//end traversed listDTO
            }//end if listDTO existed
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return result;
    }

    @Override
    public List<MeetingEntity> getByHostId(String hostId) throws ConnectionException {
        List<MeetingEntity> result = null;
        try{
            //get data from DAO
            List<MeetingDTO> listDTO = meetingSource.getMeetingsByHost(hostId);
            if (listDTO != null) {
                if(result == null){
                    result = new ArrayList<>();
                }
                for(MeetingDTO dto:listDTO){
                    //get PlatformUrlsDTO
                    PlatformUrlsDTO platformUrlsDTO = meetingPlatformUrlSource.getUrl(dto.getHost_id(), dto.getPlatform_id());
                    result.add(new MeetingEntity(dto.getId(),dto.getTitle(),
                            new MeetingPlatform(MeetingPlatform.PLATFORM.values()[platformUrlsDTO.getPlaformId()-1], dto.getHost_id(),platformUrlsDTO.getUrl()),
                            dto.getHost_id(),dto.getStartTime(),dto.getEndTime(),dto.getDescription()));
                }//end traversed listDTO
            }//end if listDTO existed
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return result;
    }

    @Override
    public MeetingEntity create(String title, MeetingPlatform.PLATFORM platform, String hostId, long startTime, long endTime, String description) throws ConnectionException {
        MeetingEntity meeting = null;
        try{
            int platformId = 0;
            if(platform.toString().equals("GOOGLE_MEET")){
                platformId = 1;
            }else{
                platformId=2;
            }
            String id = System.currentTimeMillis()+"";
            MeetingDTO dto = meetingSource.createMeeting(id,title,platformId,hostId,1,startTime,endTime,description);
            if(dto!=null){
                PlatformUrlsDTO platformUrlsDTO = meetingPlatformUrlSource.getUrl(dto.getHost_id(), dto.getPlatform_id());
                meeting = new MeetingEntity(id,title,
                        new MeetingPlatform(MeetingPlatform.PLATFORM.values()[platformId-1], hostId,platformUrlsDTO.getUrl()),
                        hostId,startTime,endTime,description);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return meeting;
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
                PlatformUrlsDTO platformUrlsDTO = meetingPlatformUrlSource.getUrl(dto.getHost_id(), dto.getPlatform_id());
                meeting = new MeetingEntity(meetingId,title,
                        new MeetingPlatform(MeetingPlatform.PLATFORM.values()[platformId-1], platformUrlsDTO.getHostId(),platformUrlsDTO.getUrl()),
                        platformUrlsDTO.getHostId(),startTime,endTime,description);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex.getMessage());
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
                    //get PlatformUrlsDTO
                    PlatformUrlsDTO platformUrlsDTO = meetingPlatformUrlSource.getUrl(dto.getHost_id(), dto.getPlatform_id());
                    result = new MeetingEntity(dto.getId(),dto.getTitle(),
                            new MeetingPlatform(MeetingPlatform.PLATFORM.values()[platformUrlsDTO.getPlaformId()-1], dto.getHost_id(),platformUrlsDTO.getUrl()),
                            dto.getHost_id(),dto.getStartTime(),dto.getEndTime(),dto.getDescription());
            }//end if DTO existed
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return result;
    }

}
