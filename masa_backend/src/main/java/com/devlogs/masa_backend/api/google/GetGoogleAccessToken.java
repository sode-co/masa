package com.devlogs.masa_backend.api.google;

import com.devlogs.masa_backend.common.helper.MasaLog;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;

import java.io.IOException;

import static com.devlogs.masa_backend.common.Masa.*;
import static com.devlogs.masa_backend.common.Masa.GOOGLE_LINK_GET_USER_INFO;

public class GetGoogleAccessToken {
    public String[] getToken(final String code) throws ClientProtocolException, IOException {
        String response = Request.Post(GOOGLE_LINK_GET_TOKEN)
                .bodyForm(Form.form().add("client_id", CLIENT_ID)
                        .add("client_secret", GOOGLE_CLIENT_SECRET)
                        .add("redirect_uri", GOOGLE_REDIRECT_URI).add("code", code)
                        .add("grant_type", GOOGLE_GRANT_TYPE).build())
                .execute().returnContent().asString();
        JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
        MasaLog.normalLog("Refresh token: " + jobj);
        String accessToken = jobj.get("access_token").toString().replaceAll("\"", "");
        String refreshToken = jobj.get("refresh_token").toString().replaceAll("\"", "");
        String[] tokens = {accessToken, refreshToken};
        return tokens;
    }

    public String getJson(final String accessToken) throws ClientProtocolException, IOException {
        String link = GOOGLE_LINK_GET_USER_INFO + accessToken;
        String response = Request.Get(link).execute().returnContent().asString();
        return response;
    }
}
