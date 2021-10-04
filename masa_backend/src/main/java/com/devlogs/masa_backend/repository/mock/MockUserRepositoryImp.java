package com.devlogs.masa_backend.repository.mock;

import com.devlogs.masa_backend.data.mock.MockUserDataSource;
import com.devlogs.masa_backend.domain.entities.UserEntity;
import com.devlogs.masa_backend.domain.entities.UserRole;
import com.devlogs.masa_backend.domain.entities.UserStatus;
import com.devlogs.masa_backend.domain.errors.AlreadyExistException;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.errors.NotFoundException;
import com.devlogs.masa_backend.domain.ports.UserRepository;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Repository này thường sẽ được tạo bởi người code frontend, trong những trường hợp:
 * Database chưa hoàn thiện xong,
 * Database bị lỗi đang fixbug,
 * Hay cần thêm dữ liệu mới nhưng database chưa update kịp.
 * */
public class MockUserRepositoryImp implements UserRepository {
    private MockUserDataSource mockData;

    @Inject
    public MockUserRepositoryImp(MockUserDataSource mockData) {
        this.mockData = mockData;
    }

    @Override
    public UserEntity getUserByEmail(String email) throws ConnectionException {
        // Vì ở đây là dữ liệu ảo nên dữ liệu chỉ là mảng bình thường thôi
        // Nếu tìm thấy thì trả về
        // Nếu không tìm thấy thì ném exception
        // Đây là cú pháp của Java mới, nên ai chưa hiểu có thể bỏ qua.
        Optional<UserEntity> result = MockUserDataSource.data.stream().filter(u-> u.getEmail().equals(email)).findFirst();
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }

    @Override
    public List<UserEntity> getAllAdmin() throws ConnectionException {
        return MockUserDataSource.data.stream().filter((i) -> i.getRole().getType() == UserRole.TYPE.ADMIN).collect(Collectors.toList());
    }

    @Override
    public UserEntity getUserById(String id) throws ConnectionException {
        // Vì ở đây là dữ liệu ảo nên dữ liệu chỉ là mảng bình thường thôi
        // Nếu tìm thấy thì trả về
        // Nếu không tìm thấy thì ném exception
        // Đây là cú pháp của Java mới, nên ai chưa hiểu có thể bỏ qua.
        Optional<UserEntity> result = MockUserDataSource.data.stream().filter(u-> u.getId().equals(id)).findFirst();
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }

    @Override
    public UserEntity addUser(String email, String fullName, String avatar, UserRole role, UserStatus userStatus) throws ConnectionException {
        UserEntity newUser = new UserEntity(System.currentTimeMillis() + "",email,fullName, role, userStatus);
        MockUserDataSource.data.add(newUser);
        return newUser;

    }

    @Override
    public List<UserEntity> getAllUser() throws ConnectionException {
        return MockUserDataSource.data;
    }

    @Override
    public UserEntity blockUser(String userID, UserStatus status) throws ConnectionException, NotFoundException {
        Optional<UserEntity> result = MockUserDataSource.data.stream().filter(u-> u.getId().equals(userID)).findFirst();
        UserEntity userBlocked = null;
        if (result.isPresent()) {
            userBlocked = result.get();
            userBlocked.setStatus(new UserStatus(status.getStatus()));
        }
        return userBlocked;
    }

    @Override
    public List<UserEntity> getUserByRole(UserRole role) throws ConnectionException {
        return null;
    }

    @Override
    public void updateUserRole(String userID, UserRole role) throws ConnectionException {
        Optional<UserEntity> result = MockUserDataSource.data.stream().filter(u-> u.getId().equals(userID)).findFirst();
        UserEntity userUpdateRole = null;
        if (result.isPresent()) {
            userUpdateRole = result.get();
            userUpdateRole.setRole(new UserRole(role.getType()));
        }
    }
}
