package com.devlogs.masa_backend.repository.meeting_question;

import com.devlogs.masa_backend.data.remote_database.MeetingQuestionDAO;
import com.devlogs.masa_backend.data.remote_database.MeetingQuestionDTO;
import com.devlogs.masa_backend.data.remote_database.UserDao;
import com.devlogs.masa_backend.data.remote_database.UserDto;
import com.devlogs.masa_backend.domain.entities.*;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.ports.MeetingQuestionRepository;

import javax.inject.Inject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MeetingQuestionRepositoryImp implements MeetingQuestionRepository {

    private MeetingQuestionDAO meetingQuestionDAO;
    private UserDao userDao;
    @Inject
    public MeetingQuestionRepositoryImp(MeetingQuestionDAO meetingQuestionDAO, UserDao userDao) {
        this.meetingQuestionDAO = meetingQuestionDAO;
        this.userDao = userDao;
    }
    public UserRole convertRole(int role_id) {
        UserRole.TYPE type = null;
        for (UserRole.TYPE value : UserRole.TYPE.values()) {
            type = UserRole.TYPE.values()[role_id - 1];
        }
        return new UserRole(type);
    }

    public UserStatus convertStatus(int status_id) {
        UserStatus.STATUS status;
        if (status_id == 1) {
            status = UserStatus.STATUS.BLOCKED;
        } else status = UserStatus.STATUS.ACTIVE;

        return new UserStatus(status);
    }

    public UserEntity convertDto(UserDto dto) {

        UserEntity entity = new UserEntity(dto.getId(), dto.getEmail(), dto.getFullName(),
                convertRole(dto.getRole_ID()), convertStatus(dto.getStatus_id()));
        return entity;
    }
    @Override
    public List<MeetingQuestionEntity> getAllQuestionsByMeetingId(String id) throws ConnectionException {
        List<MeetingQuestionEntity> result = new ArrayList<>();
        try {
            List<MeetingQuestionDTO> listDto = meetingQuestionDAO.getAllQuestionsByMeetingId(id);
            for (MeetingQuestionDTO dto : listDto){
                UserDto userDto = userDao.getUserById(dto.getUserId());
                UserEntity user = convertDto(userDto);
                result.add(new MeetingQuestionEntity(dto.getId(), dto.getTitle(), user, dto.getMeetingId(), dto.getCreatedDate()));
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            throw new ConnectionException(ex.getMessage());
        }
        return result;
    }

    @Override
    public MeetingQuestionEntity createMeetingQuestion(String title, String userId, String meetingId) throws ConnectionException {
        MeetingQuestionEntity result = null;
        try {
            String id= System.currentTimeMillis()+"";
            long createdDate = System.currentTimeMillis();
            MeetingQuestionDTO dto = meetingQuestionDAO.createQuestions(id,title,userId,meetingId,createdDate);
            if (dto!=null){
                UserDto userDto = userDao.getUserById(dto.getUserId());
                UserEntity user = convertDto(userDto);
                result = new MeetingQuestionEntity(dto.getId(), dto.getTitle(), user, dto.getMeetingId(), dto.getCreatedDate());
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            throw new ConnectionException(ex.getMessage());
        }
        return result;
    }
}
