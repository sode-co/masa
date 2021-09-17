package com.devlogs.masa_backend.api.google;

import com.devlogs.masa_backend.common.helper.MasaLog;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.ports.google_api.GooglePojo;
import com.devlogs.masa_backend.domain.ports.google_api.LoginWithGoogleApi;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import javax.inject.Inject;
import java.io.IOException;
import static com.devlogs.masa_backend.common.Masa.*;
import static com.devlogs.masa_backend.common.Masa.GOOGLE_LINK_GET_USER_INFO;

public class LoginWithGoogleApiImp implements LoginWithGoogleApi {

    @Inject
    public LoginWithGoogleApiImp() {

    }

    public GooglePojo login (String code) throws ConnectionException {
        String accessToken = null;
        try {
            accessToken = getToken(code);
            GooglePojo googlePojo = getUserInfo(accessToken);
            return googlePojo;
        } catch (IOException e) {
            throw new ConnectionException(e.getMessage());
        }
    }

    private String getToken(final String code) throws ClientProtocolException, IOException {
        String response = Request.Post(GOOGLE_LINK_GET_TOKEN)
                .bodyForm(Form.form().add("client_id", CLIENT_ID)
                        .add("client_secret", GOOGLE_CLIENT_SECRET)
                        .add("redirect_uri", GOOGLE_REDIRECT_URI).add("code", code)
                        .add("grant_type", GOOGLE_GRANT_TYPE).build())
                .execute().returnContent().asString();
        JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
        String accessToken = jobj.get("access_token").toString().replaceAll("\"", "");
        return accessToken;
    }

    private String getJson(final String accessToken) throws ClientProtocolException, IOException {
        String link = GOOGLE_LINK_GET_USER_INFO + accessToken;
        String response = Request.Get(link).execute().returnContent().asString();
        return response;
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
