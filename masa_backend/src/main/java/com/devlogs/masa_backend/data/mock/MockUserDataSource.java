package com.devlogs.masa_backend.data.mock;

import com.devlogs.masa_backend.domain.entities.UserEntity;
import com.devlogs.masa_backend.domain.entities.UserRole;
import com.devlogs.masa_backend.domain.entities.UserStatus;

import javax.inject.Inject;
import java.util.ArrayList;

/**
 * Fake dữ liệu ở đây, có thể push lên git share với người khác sử dụng cùng, hiệu quả hơn dễ thay đổi hơn
 * */
public class MockUserDataSource {
    public static ArrayList<UserEntity> data = new ArrayList();

    static {
        data.add( new UserEntity ("123","ngoc@gmail.com", "Lam Tam Nhu"
                , new UserRole(UserRole.TYPE.STUDENT)
                , new UserStatus(UserStatus.STATUS.ACTIVE)));
        data.add(new UserEntity ("12314","ngoc2@gmail.com", "Lam Tam Nhu3"
                , new UserRole(UserRole.TYPE.MENTOR)
                , new UserStatus(UserStatus.STATUS.ACTIVE)));
        data.add(new UserEntity ("123345","ngoc1@gmail.com", "Lam Tam Nhu2"
                , new UserRole(UserRole.TYPE.MENTOR)
                , new UserStatus(UserStatus.STATUS.ACTIVE)));
        data.add(new UserEntity ("122345","tiendang1@gmail.com", "Lam Tam Nhu2"
                , new UserRole(UserRole.TYPE.STUDENT)
                , new UserStatus(UserStatus.STATUS.ACTIVE)));
    }
    @Inject
    public MockUserDataSource () {

    }
}
