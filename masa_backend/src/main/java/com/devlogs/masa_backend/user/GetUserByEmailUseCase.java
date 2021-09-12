package com.devlogs.masa_backend.user;

import com.devlogs.masa_backend.domain.entities.UserEntity;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.errors.NotFoundException;
import com.devlogs.masa_backend.domain.ports.UserRepository;
import com.devlogs.masa_backend.user.GetUserByEmailUseCase.Result.*;

public class GetUserByEmailUseCase {

    /**
     * Quy tắc viết Result
     * 1. class Result luôn luôn là static class
     * 2. các result con phải là static class và kế thừa outer class để nó cùng kiểu dữ liệu là Result để mình return
     * 3. Chỉ viết những result nào mình nghĩ servlet có thể handle, còn lại bỏ vào GeneralError cùng với message
     * */
    public static class Result {
        public static class Success extends Result {
            private UserEntity user;

            public Success(UserEntity user) {
                this.user = user;
            }

            public UserEntity getUser() {
                return user;
            }
        }

        public static class ConnectionError extends Result {

        }

        public static class NotFoundError extends Result {
        }

        public static class GeneralError extends Result {
            private String message;

            public GeneralError(String message) {
                this.message = message;
            }

            public String getMessage() {
                return message;
            }
        }
    }

    /**@Important Usecase không có nhiệm vụ khởi tạo dependencies, nên tất cả dependencies đều phải truyền qua constructor*/
    private UserRepository userRepository;

    public GetUserByEmailUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Result executes (String email) {
        try {
            UserEntity user = userRepository.getUserByEmail(email);
            return new Success(user);
        } catch (NotFoundException e) {
            return new NotFoundError ();
        } catch (ConnectionException e) {
            return new ConnectionError();
        }
    }
}
