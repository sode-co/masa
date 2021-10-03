package com.devlogs.masa_backend.login;

import com.devlogs.masa_backend.domain.entities.UserEntity;
import com.devlogs.masa_backend.domain.entities.UserRole;
import com.devlogs.masa_backend.domain.entities.UserStatus;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.ports.google_api.GoogleGetUserEndpoint;
import com.devlogs.masa_backend.domain.ports.google_api.GooglePojo;
import com.devlogs.masa_backend.domain.ports.testonly.UserRepository;
import com.devlogs.masa_backend.login.LoginWithGoogleUseCase.Result;
import com.devlogs.masa_backend.login_convention.EmailValidator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.devlogs.masa_backend.login.LoginWithGoogleUseCase.Result.*;
import static com.devlogs.masa_backend.login.common.TestConfig.GROUP.HAS_INTERACTION_WITH_USER_REPOSITORY;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginWithGoogleUseCaseTestt {
    private LoginWithGoogleUseCase SUT;

    @BeforeMethod(alwaysRun = true)
    public void setup () {

        // Ngọc sẽ code tới đoạn này
//        SUT = new LoginWithGoogleUseCase();
    }

    // Comment mấy cái test case tui chụp vô đây nha

    // 1. ACCESS TOKEN IS PASSED TO GOOGLE ENDPOINT
    // 2. 2.GOOGLE POJO IS PASSED CORRECTLY TO REPOSITORY


}