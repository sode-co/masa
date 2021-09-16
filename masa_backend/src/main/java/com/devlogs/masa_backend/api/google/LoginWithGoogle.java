package com.devlogs.masa_backend.api.google;

import com.devlogs.masa_backend.domain.entities.UserEntity;

import javax.inject.Inject;
import java.io.IOException;

public class LoginWithGoogle {

    @Inject
    public LoginWithGoogle () {

    }

    public GooglePojo login (String code) throws IOException {
        String accessToken = GoogleUtils.getToken(code);
        GooglePojo googlePojo = GoogleUtils.getUserInfo(accessToken);
        return googlePojo;
    }
}
