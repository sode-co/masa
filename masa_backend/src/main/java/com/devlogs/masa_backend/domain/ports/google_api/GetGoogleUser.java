package com.devlogs.masa_backend.domain.ports.google_api;

import com.devlogs.masa_backend.domain.errors.ConnectionException;

public interface GetGoogleUser {
     GooglePojo getUser(String accessToken) throws ConnectionException;
}