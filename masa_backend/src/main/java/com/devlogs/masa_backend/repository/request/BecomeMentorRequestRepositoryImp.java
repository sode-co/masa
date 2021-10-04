package com.devlogs.masa_backend.repository.request;

import com.devlogs.masa_backend.common.helper.MasaLog;
import com.devlogs.masa_backend.data.remote_database.RequestDao;
import com.devlogs.masa_backend.data.remote_database.RequestDto;
import com.devlogs.masa_backend.domain.entities.BecomeMentorRequestEntity;
import com.devlogs.masa_backend.domain.entities.RequestEntity;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.ports.BecomeMentorRequestRepository;
import com.google.gson.Gson;

import javax.inject.Inject;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class BecomeMentorRequestRepositoryImp implements BecomeMentorRequestRepository {
    private RequestDao requestDao;
    private UUID uuid;

    @Inject
    public BecomeMentorRequestRepositoryImp(RequestDao requestDao) {
        this.requestDao = requestDao;
    }

    private BecomeMentorRequestEntity fromRequestDto(RequestDto dto) {
        RequestEntity.STATUS status = null;
        switch (dto.getStatusId()) {
            case 1:
                status = RequestEntity.STATUS.DENIED;
                break;
            case 2:
                status = RequestEntity.STATUS.PROCESSING;
                break;
            case 3:
                status = RequestEntity.STATUS.APPROVED;
                break;
            default:
                throw new RuntimeException("Invalid request status: " + dto.getStatusId());
        }

        BecomeMentorRequestPayload payload = new Gson().fromJson(dto.getPayload(), BecomeMentorRequestPayload.class);
        return new BecomeMentorRequestEntity(dto.getId(), dto.getDescription(), dto.getUserId(), status,payload.getZoomUrl(), payload.getMeetUrl(),dto.getCreatedDate());
    }

    /*
    * 1: DENIED
    * 2: APPROVE
    * 3: PROCESSING
    * */

    @Override
    public BecomeMentorRequestEntity addRequest(String userId, String description, String meetUrl, String zoomUrl, RequestEntity.STATUS status) throws ConnectionException {
        BecomeMentorRequestPayload payload = new BecomeMentorRequestPayload(zoomUrl, meetUrl);
        String payloadInJson= new Gson().toJson(payload);

        try {
            RequestDto addedRequest = requestDao.addRequest(UUID.randomUUID().toString().substring(0, 8), userId, description, 1, 2,payloadInJson, System.currentTimeMillis());
            return fromRequestDto(addedRequest);
        } catch (SQLException e) {
            throw new RuntimeException("Sql exception: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new ConnectionException(e.getMessage());
        }
    }

    @Override
    public List<BecomeMentorRequestEntity> getAll() throws ConnectionException {
        try {
            List<RequestDto> results = requestDao.getAll();
            return results.stream().map(this::fromRequestDto).collect(Collectors.toList());
        } catch (SQLException e) {
            throw new RuntimeException("Sql exception: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new ConnectionException(e.getMessage());
        }
    }

    @Override
    public List<BecomeMentorRequestEntity> getRequestByUserId(String userId) throws ConnectionException {
        try {
            List<RequestDto> results = requestDao.getByUserId(userId);
            return results.stream().map(this::fromRequestDto).collect(Collectors.toList());
        } catch (SQLException e) {
            throw new RuntimeException("Sql exception: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new ConnectionException(e.getMessage());
        }
    }

    @Override
    public BecomeMentorRequestEntity getRequestById(String id) throws ConnectionException {
        MasaLog.normalLog("RequestId: " + id);
        try {
            RequestDto result = requestDao.getById(id);
            if (result == null) {
                return null;
            }
            return fromRequestDto(result);
        } catch (SQLException e) {
            throw new RuntimeException("Sql exception: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new ConnectionException(e.getMessage());
        }
    }

    @Override
    public void answerRequest(String requestId, RequestEntity.STATUS status) throws ConnectionException {

    }

    @Override
    public void updateRequestStatus(String requestId, RequestEntity.STATUS status) throws ConnectionException {
        try {
            int statusId = 0;
            switch (status) {
                case DENIED:
                    statusId = 1;
                    break;
                case PROCESSING:
                    statusId = 2;
                    break;
                case APPROVED:
                    statusId = 3;
                    break;
            }
            if (statusId != 0) {
                requestDao.updateRequestStatus(requestId, statusId);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Sql exception: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
