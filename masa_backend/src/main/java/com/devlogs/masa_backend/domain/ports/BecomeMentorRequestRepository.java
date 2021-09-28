package com.devlogs.masa_backend.domain.ports;

import com.devlogs.masa_backend.domain.entities.BecomeMentorRequestEntity;
import com.devlogs.masa_backend.domain.entities.RequestEntity;
import com.devlogs.masa_backend.domain.errors.ConnectionException;

import java.util.List;

public interface BecomeMentorRequestRepository {
    BecomeMentorRequestEntity addRequest(String userId, String description, String meetUrl, String zoomUrl, RequestEntity.STATUS status) throws ConnectionException;

    List<BecomeMentorRequestEntity> getAll() throws ConnectionException;

    List<BecomeMentorRequestEntity> getRequestByUserId(String userId) throws ConnectionException;

    BecomeMentorRequestEntity getRequestById(String id) throws ConnectionException;


    void answerRequest(String requestId, RequestEntity.STATUS status) throws ConnectionException;


    void updateRequestStatus(String requestId, RequestEntity.STATUS status) throws ConnectionException;

}
