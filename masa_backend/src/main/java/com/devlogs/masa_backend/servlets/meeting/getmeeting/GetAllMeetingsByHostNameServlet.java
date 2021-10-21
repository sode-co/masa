package com.devlogs.masa_backend.servlets.meeting.getmeeting;

import com.devlogs.masa_backend.common.annotations.AccessRole;
import com.devlogs.masa_backend.domain.entities.MeetingEntity;
import com.devlogs.masa_backend.domain.entities.UserEntity;
import com.devlogs.masa_backend.manage.GetUserByNameUseCase;
import com.devlogs.masa_backend.meeting.GetAllMeetingsByHostNameUseCase;
import com.devlogs.masa_backend.meeting.GetMeetingByHostUseCase;
import com.devlogs.masa_backend.servlets.common.base.BaseHttpServlet;
import com.devlogs.masa_backend.servlets.meeting.common.GetMeetingResponse;
import com.devlogs.masa_backend.user.GetUserByIdUseCase;
import com.google.gson.Gson;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import static com.devlogs.masa_backend.domain.entities.UserRole.TYPE.*;

@AccessRole(roles = {ADMIN, MENTOR, STUDENT})
@WebServlet(name = "getmeetingbyhostname", urlPatterns = {"/api/meeting-management/meetings/hostname/*"})
public class GetAllMeetingsByHostNameServlet extends BaseHttpServlet {
    @Inject
    protected GetAllMeetingsByHostNameUseCase getAllMeetingsByHostNameUseCase;
    @Inject
    protected GetUserByIdUseCase getUserByIdUseCase;
    @Override
    public void init() throws ServletException {
        super.init();
        getControllerComponent().inject(this);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURL().toString();
        String hostname = url.substring(url.lastIndexOf("/") +1);

        if (hostname.contains("/")) {hostname = hostname.replaceAll("/", "");}
        hostname = hostname.replaceAll("%20"," ");
        if (hostname.trim().isEmpty()) {
            getRequestComponent().getResponseHelper().responseMessage(400, "Invalid host name");
        }
        GetAllMeetingsByHostNameUseCase.Result result = getAllMeetingsByHostNameUseCase.executes(hostname);
        System.out.println(result.toString());
        if (result instanceof GetAllMeetingsByHostNameUseCase.Result.ConnectionError) {
            getRequestComponent().getResponseHelper().responseMessage(500, "Connection to db error");
        } else if ( result instanceof GetAllMeetingsByHostNameUseCase.Result.Success) {
            ArrayList<GetMeetingResponse.Data> responseData = new ArrayList<>();
            ArrayList<UserEntity> hosts = new ArrayList<>();
            Optional<UserEntity> cachedHost;
            for (MeetingEntity meeting : ((GetAllMeetingsByHostNameUseCase.Result.Success) result).meetings) {
                cachedHost = hosts.stream().filter(user -> user.id.equals(meeting.getHostId())).findFirst();
                if (!cachedHost.isPresent()) {
                    GetUserByIdUseCase.Result getUserResult = getUserByIdUseCase.executes(meeting.getHostId());
                    if (getUserResult instanceof GetUserByIdUseCase.Result.Success) {
                        cachedHost = Optional.of(((GetUserByIdUseCase.Result.Success) getUserResult).getUser());
                        hosts.add(cachedHost.get());
                    }
                }
                responseData.add(new GetMeetingResponse.Data(meeting.getTitle(),meeting.getPlatform(), meeting.getTopic(), cachedHost.get(), meeting.getStartTime(), meeting.getEndTime(), meeting.getDescription()));
                cachedHost = Optional.ofNullable(null);

            }
            GetMeetingResponse response = new GetMeetingResponse(responseData);

            String json = new Gson().toJson(response);
            getRequestComponent().getResponseHelper().responseJsonOk(json);
        }
    }
}
