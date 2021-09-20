package com.devlogs.masa_backend.data.mock;

import com.devlogs.masa_backend.domain.entities.AppointmentEntity;

import javax.inject.Inject;
import java.util.ArrayList;

public class MockAppointmentDatasource {
    public static ArrayList<AppointmentEntity> datas = new ArrayList<>();

    @Inject
    public MockAppointmentDatasource () {

    }

    static {
        datas.add(new AppointmentEntity("123", "12345"));
        datas.add(new AppointmentEntity("122345", "123457"));
        datas.add(new AppointmentEntity("122345", "1234"));
        datas.add(new AppointmentEntity("123", "123457"));
    }
}
