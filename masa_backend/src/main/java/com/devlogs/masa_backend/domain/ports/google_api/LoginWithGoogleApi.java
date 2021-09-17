package com.devlogs.masa_backend.domain.ports.google_api;

import com.devlogs.masa_backend.domain.errors.ConnectionException;

public interface LoginWithGoogleApi {
     GooglePojo login(String code) throws ConnectionException;
}