package com.devlogs.masa_backend.api.google;

import com.devlogs.masa_backend.common.helper.MasaLog;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.ports.google_api.GooglePojo;
import com.devlogs.masa_backend.domain.ports.google_api.GetGoogleUser;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import javax.inject.Inject;
import java.io.IOException;
import static com.devlogs.masa_backend.common.Masa.*;
import static com.devlogs.masa_backend.common.Masa.GOOGLE_LINK_GET_USER_INFO;

public class GetGoogleUserImp implements GetGoogleUser {

    @Inject
    public GetGoogleUserImp() {

    }

    public GooglePojo getUser (String accessToken) throws ConnectionException {
        try {
            GooglePojo googlePojo = getUserInfo(accessToken);
            return googlePojo;
        } catch (IOException e) {
            throw new ConnectionException(e.getMessage());
        }
    }

    private GooglePojo getUserInfo(final String accessToken) throws ClientProtocolException, IOException {
        String link = GOOGLE_LINK_GET_USER_INFO + accessToken;
        String response = Request.Get(link).execute().returnContent().asString();
        MasaLog.normalLog("Json: " + response);
        GooglePojo googlePojo = new Gson().fromJson(response, GooglePojo.class);
        System.out.println("Google POJO: " + googlePojo.getEmail());
        return googlePojo;
    }
}