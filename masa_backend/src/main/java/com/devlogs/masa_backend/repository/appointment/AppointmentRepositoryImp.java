package com.devlogs.masa_backend.repository.appointment;

import com.devlogs.masa_backend.data.remote_database.AppointmentDAO;
import com.devlogs.masa_backend.data.remote_database.AppointmentDTO;
import com.devlogs.masa_backend.domain.entities.AppointmentEntity;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.ports.AppointmentRepository;

import javax.inject.Inject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AppointmentRepositoryImp implements AppointmentRepository {

    private AppointmentDAO appointmentDatasource;
    @Inject
    public AppointmentRepositoryImp(AppointmentDAO appointmentDatasource) {
        this.appointmentDatasource = appointmentDatasource;
    }

    @Override
    public AppointmentEntity createAppointment(String userId, String meetingId) throws ConnectionException {
        AppointmentEntity appointment = null;
        try{
            AppointmentDTO dto = appointmentDatasource.createAppointment(userId,meetingId);
            if(dto!=null){
                appointment = new AppointmentEntity(dto.getUserId(),dto.getMeetingId());
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return  appointment;
    }

    @Override
    public List<AppointmentEntity> getUserAppointment(String userId) throws ConnectionException {
        List<AppointmentEntity> result = null;
        try{
            List<AppointmentDTO> listDto = appointmentDatasource.getUserAppointments(userId);
            if(listDto!=null){
                for (AppointmentDTO dto:listDto){
                    if(result == null){
                        result = new ArrayList<>();
                    }
                    result.add(new AppointmentEntity(dto.getUserId(), dto.getMeetingId()));
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return  result;
    }

    @Override
    public AppointmentEntity getAppointment(String userId, String meetingId) throws ConnectionException {
        try {
            AppointmentDTO queryResult = appointmentDatasource.getAppointment(userId, meetingId);
            if (queryResult == null) {
                return null;
            }
            return new AppointmentEntity(queryResult.getUserId(), queryResult.getMeetingId());
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new ConnectionException(e.getMessage());
        }

    }


    @Override
    public List<AppointmentEntity> getMeetingAppointment(String meetingId) throws ConnectionException {
        List<AppointmentEntity> result = null;
        try{
            List<AppointmentDTO> listDto = appointmentDatasource.getMeetingAppointments(meetingId);
            if(listDto!=null){
                for (AppointmentDTO dto:listDto){
                    if(result == null){
                        result = new ArrayList<>();
                    }
                    result.add(new AppointmentEntity(dto.getUserId(), dto.getMeetingId()));
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return  result;
    }
}
