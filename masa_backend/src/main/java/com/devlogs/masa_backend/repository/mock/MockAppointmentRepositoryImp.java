package com.devlogs.masa_backend.repository.mock;

import com.devlogs.masa_backend.data.mock.MockAppointmentDatasource;
import com.devlogs.masa_backend.domain.entities.AppointmentEntity;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.ports.AppointmentRepository;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class MockAppointmentRepositoryImp implements AppointmentRepository {

    private MockAppointmentDatasource mockAppointmentDatasource;

    @Inject
    public MockAppointmentRepositoryImp(MockAppointmentDatasource mockAppointmentDatasource) {
        this.mockAppointmentDatasource = mockAppointmentDatasource;
    }

    @Override
    public AppointmentEntity createAppointment(String userId, String meetingId) throws ConnectionException {
        AppointmentEntity newAppointment = new AppointmentEntity(userId, meetingId);
        MockAppointmentDatasource.datas.add(newAppointment);
        return newAppointment;
    }

    @Override
    public List<AppointmentEntity> getUserAppointment(String userId) throws ConnectionException {
        ArrayList<AppointmentEntity> results = new ArrayList<>();

        for (AppointmentEntity data : MockAppointmentDatasource.datas) {
            if (data.getUserId().equals(userId)) {
                results.add(data);
            }
        }
        return results;
    }

    @Override
    public AppointmentEntity getAppointment(String userId, String meetingId) throws ConnectionException {
        return null;
    }

    @Override
    public List<AppointmentEntity> getMeetingAppointment(String meetingId) throws ConnectionException {
        ArrayList<AppointmentEntity> results = new ArrayList<>();

        for (AppointmentEntity data : MockAppointmentDatasource.datas) {
            if (data.getMeetingId().equals(meetingId)) {
                results.add(data);
            }
        }
        return results;
    }

    @Override
    public void removeAppointment(String userId, String meetingId) throws ConnectionException {

    }
}
