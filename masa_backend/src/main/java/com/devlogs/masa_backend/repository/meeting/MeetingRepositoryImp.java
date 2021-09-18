package com.devlogs.masa_backend.repository.meeting;

import com.devlogs.masa_backend.data.remote_database.MeetingDAO;
import com.devlogs.masa_backend.data.remote_database.MeetingDTO;
import com.devlogs.masa_backend.domain.entities.MeetingEntity;
import com.devlogs.masa_backend.domain.entities.MeetingPlatform;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.errors.NotFoundException;
import com.devlogs.masa_backend.domain.ports.MeetingRepository;
import com.devlogs.masa_backend.repository.user.UserRepositoryImp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MeetingRepositoryImp implements MeetingRepository {

    private MeetingDAO dataSource;
    private UserRepositoryImp userDataSource;

    public MeetingRepositoryImp(MeetingDAO dataSource, UserRepositoryImp userDataSource) {
        this.dataSource = dataSource;
        this.userDataSource = userDataSource;
    }

    @Override
    public List<MeetingEntity> getAll() throws ConnectionException {
        try{
            dataSource.getAllMeetings();
            List<MeetingDTO> listDTO = dataSource.getListMeeting();
            List<MeetingEntity> result = new ArrayList<>();

            for(MeetingDTO dto:listDTO){
                //eetingPlatform meetingPlatform = new MeetingPlatform(dto.getPlatform_id(), dto.getHost_id(), )
            }

        } catch (SQLException throwables) {
            throw new RuntimeException(throwables.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {

        }
        return null;
    }

    @Override
    public List<MeetingEntity> getByHostId(String hostId) throws ConnectionException {
        return null;
    }

    @Override
    public MeetingEntity create(String title, MeetingPlatform.PLATFORM platform, String hostId, long startTime, long endTime, String description) throws ConnectionException {
        return null;
    }

    @Override
    public MeetingEntity updateMeeting(String meetingId, String title, MeetingPlatform.PLATFORM platform, long startTime, long endTime, String description) throws ConnectionException, NotFoundException {
        return null;
    }

    @Override
    public MeetingEntity getById(String meetingId) throws ConnectionException {
        return null;
    }

}
