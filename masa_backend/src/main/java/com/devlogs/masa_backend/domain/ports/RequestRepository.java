package com.devlogs.masa_backend.domain.ports;

import com.devlogs.masa_backend.domain.entities.RequestEntity;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.errors.NotFoundException;

import java.util.List;

public interface RequestRepository {
    RequestEntity addRequest(String userId, String description, RequestEntity.TYPE type, RequestEntity.STATUS status) throws ConnectionException;


    List<RequestEntity> getAll() throws ConnectionException;

    List<RequestEntity> getRequestByUserId(String userId) throws ConnectionException;

    RequestEntity getRequestById(String id) throws ConnectionException;

    void answerRequest(String requestId, RequestEntity.STATUS status) throws ConnectionException;
}
