package com.devlogs.masa_backend.data.mock;

import com.devlogs.masa_backend.domain.entities.UserEntity;
import com.devlogs.masa_backend.domain.entities.UserRole;
import com.devlogs.masa_backend.domain.entities.UserStatus;
import java.util.ArrayList;

/**
 * Fake dữ liệu ở đây, có thể push lên git share với người khác sử dụng cùng, hiệu quả hơn dễ thay đổi hơn
 * */
public class MockUserDataSource {
    public ArrayList<UserEntity> data = new ArrayList();

    public MockUserDataSource () {
        data.add(new UserEntity ("ngoc@gmail.com", "Lam Tam Nhu"
                , new UserRole(UserRole.TYPE.ADMIN)
                , new UserStatus(UserStatus.STATUS.ACTIVE)));
        data.add(new UserEntity ("ngoc2@gmail.com", "Lam Tam Nhu3"
                , new UserRole(UserRole.TYPE.ADMIN)
                , new UserStatus(UserStatus.STATUS.ACTIVE)));
        data.add(new UserEntity ("ngoc1@gmail.com", "Lam Tam Nhu2"
                , new UserRole(UserRole.TYPE.USER)
                , new UserStatus(UserStatus.STATUS.ACTIVE)));
    }
}
