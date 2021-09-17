package com.devlogs.masa_backend.common.di.controller;

import com.devlogs.masa_backend.domain.ports.UserRepository;
import com.devlogs.masa_backend.repository.mock.MockUserRepositoryImp;
import com.devlogs.masa_backend.repository.user.UserRepositoryImp;
import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
    public UserRepository provideUserRepository (MockUserRepositoryImp userRepositoryImp) {
        return userRepositoryImp;
    }
}
