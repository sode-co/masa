package com.devlogs.masa_backend.repository.mock;

import com.devlogs.masa_backend.data.mock.MockUserDataSource;
import com.devlogs.masa_backend.domain.entities.UserEntity;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.errors.NotFoundException;
import com.devlogs.masa_backend.domain.ports.UserRepository;

/**
 * Repository này thường sẽ được tạo bởi người code frontend, trong những trường hợp:
 * Database chưa hoàn thiện xong,
 * Database bị lỗi đang fixbug,
 * Hay cần thêm dữ liệu mới nhưng database chưa update kịp.
 * */
public class MockUserRepositoryImp implements UserRepository {
    private MockUserDataSource mockData = new MockUserDataSource();

    @Override
    public UserEntity getUserByEmail(String email) throws NotFoundException, ConnectionException {
        // Vì ở đây là dữ liệu ảo nên dữ liệu chỉ là mảng bình thường thôi
        // Nếu tìm thấy thì trả về
        // Nếu không tìm thấy thì ném exception
        // Đây là cú pháp của Java mới, nên ai chưa hiểu có thể bỏ qua.
        return mockData.data.stream().filter( u-> u.getEmail().equals(email)).findFirst().orElseThrow(() ->
             new NotFoundException("Could not found any user has email: " + email)
        );
    }
}
