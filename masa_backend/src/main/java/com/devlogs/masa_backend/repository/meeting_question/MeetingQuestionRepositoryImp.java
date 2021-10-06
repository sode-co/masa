package com.devlogs.masa_backend.repository.meeting_question;

import com.devlogs.masa_backend.data.remote_database.MeetingQuestionDAO;
import com.devlogs.masa_backend.data.remote_database.MeetingQuestionDTO;
import com.devlogs.masa_backend.domain.entities.MeetingEntity;
import com.devlogs.masa_backend.domain.entities.MeetingQuestionEntity;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.ports.MeetingQuestionRepository;

import javax.inject.Inject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MeetingQuestionRepositoryImp implements MeetingQuestionRepository {

    private MeetingQuestionDAO meetingQuestionDAO;
    @Inject
    public MeetingQuestionRepositoryImp(MeetingQuestionDAO meetingQuestionDAO) {
        this.meetingQuestionDAO = meetingQuestionDAO;
    }

    @Override
    public List<MeetingQuestionEntity> getAllQuestionsByMeetingId(String id) throws ConnectionException {
        List<MeetingQuestionEntity> result = new ArrayList<>();
        try {
            List<MeetingQuestionDTO> listDto = meetingQuestionDAO.getAllQuestionsByMeetingId(id);
            for (MeetingQuestionDTO dto : listDto){
                result.add(new MeetingQuestionEntity(dto.getId(), dto.getTitle(), dto.getUserId(), dto.getMeetingId(), dto.getCreatedDate()));
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
            String createdDate = System.currentTimeMillis()+"";
            MeetingQuestionDTO dto = meetingQuestionDAO.createQuestions(id,title,userId,meetingId,createdDate);
            if (dto!=null){
                result = new MeetingQuestionEntity(dto.getId(), dto.getTitle(), dto.getUserId(), dto.getMeetingId(), dto.getCreatedDate());
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            throw new ConnectionException(ex.getMessage());
        }
        return result;
    }
}
