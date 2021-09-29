package com.devlogs.masa_backend.domain.ports;

import com.devlogs.masa_backend.domain.entities.AppointmentEntity;
import com.devlogs.masa_backend.domain.errors.ConnectionException;

import java.util.List;

public interface AppointmentRepository {
    AppointmentEntity createAppointment (String userId, String meetingId) throws ConnectionException;
    List<AppointmentEntity> getUserAppointment (String userId) throws ConnectionException;
    AppointmentEntity getAppointment (String userId, String meetingId) throws ConnectionException;
    List<AppointmentEntity> getMeetingAppointment (String meetingId) throws ConnectionException;
    void removeAppointment(String userId, String meetingId) throws ConnectionException;
}
