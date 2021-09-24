package com.devlogs.masa_backend.repository.request;

import com.devlogs.masa_backend.data.remote_database.RequestDao;
import com.devlogs.masa_backend.data.remote_database.RequestDto;
import com.devlogs.masa_backend.domain.entities.RequestEntity;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.ports.RequestRepository;

import javax.inject.Inject;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class RequestRepositoryImp implements RequestRepository {
    private RequestDao requestDao;
    private UUID uuid;

    @Inject
    public RequestRepositoryImp(RequestDao requestDao) {
        this.requestDao = requestDao;
    }

    private RequestEntity fromRequestDto (RequestDto dto) {
        RequestEntity.TYPE requestType = null;

        switch (dto.getTypeId()) {
            case 1: requestType = RequestEntity.TYPE.BECOME_MENTOR; break;
            default: throw new RuntimeException("Invalid requestTypeId: " + dto.getTypeId());
        }

        RequestEntity.STATUS status = null;
        switch (dto.getStatusId()) {
            case 1: status = RequestEntity.STATUS.DENIED; break;
            case 2: status = RequestEntity.STATUS.PROCESSING; break;
            case 3: status = RequestEntity.STATUS.APPROVED; break;
            default: throw new RuntimeException("Invalid request status: " + dto.getStatusId());
        }

        return new RequestEntity(dto.getId(), dto.getDescription(), requestType, dto.getUserId(), status);
    }

    /*
    * 1: DENIED
    * 2: APPROVE
    * 3: PROCESSING
    * */
    public void answerRequest (String requestId, RequestEntity.STATUS status) throws ConnectionException {
        int statusId = 1;
        switch (status) {
            case PROCESSING: {
                statusId = 3;
                break;
            }
            case DENIED: {
                statusId = 1;
                break;
            }
            case APPROVED: {
                statusId = 2;
                break;
            }
            default: {
                throw new RuntimeException("Your status is not supported yet: " + status);
            }
        }
        try {
           requestDao.updateRequestStatus(requestId, statusId);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new ConnectionException(e.getMessage());
        }
    }

    @Override
    public RequestEntity addRequest(String userId, String description, RequestEntity.TYPE type, RequestEntity.STATUS status) throws ConnectionException {
        int typeId = -1;
        switch (type) {
            case BECOME_MENTOR: {
                typeId = 1;
                break;
            }
            default: throw new RuntimeException(String.format("Type ? is not supported by repository", type.name()));
        }
        try {
            RequestDto addedRequest = requestDao.addRequest(UUID.randomUUID().toString().substring(0,8), userId, description, typeId, 2);
            return fromRequestDto(addedRequest);
        } catch (SQLException e) {
            throw new RuntimeException("Sql exception: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new ConnectionException(e.getMessage());
        }
    }

    @Override
    public List<RequestEntity> getAll() throws ConnectionException {
        try {
            List<RequestDto> results = requestDao.getAll();
            return results.stream().map(this::fromRequestDto).collect(Collectors.toList());
        }  catch (SQLException e) {
            throw new RuntimeException("Sql exception: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new ConnectionException(e.getMessage());
        }
    }

    @Override
    public List<RequestEntity> getRequestByUserId(String userId) throws ConnectionException {
        try {
            List<RequestDto> results = requestDao.getByUserId(userId);
            return results.stream().map(this::fromRequestDto).collect(Collectors.toList());
        }  catch (SQLException e) {
            throw new RuntimeException("Sql exception: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new ConnectionException(e.getMessage());
        }
    }

    @Override
    public RequestEntity getRequestById(String id) throws ConnectionException {
        try {
            RequestDto result = requestDao.getById(id);
            return fromRequestDto(result);
        } catch (SQLException e) {
            throw new RuntimeException("Sql exception: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new ConnectionException(e.getMessage());
        }
    }
}
