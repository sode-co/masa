package com.devlogs.masa_backend.api.google;

import com.devlogs.masa_backend.common.helper.MasaLog;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.ports.google_api.GoogleGetUserEndpoint;
import com.devlogs.masa_backend.domain.ports.google_api.GooglePojo;
import com.google.gson.Gson;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;

import javax.inject.Inject;
import java.io.IOException;

import static com.devlogs.masa_backend.common.Masa.GOOGLE_LINK_GET_USER_INFO;

public class GoogleGetUserInfoEndpointImp implements GoogleGetUserEndpoint {

    @Inject
    public GoogleGetUserInfoEndpointImp() {

    }

    public Result getUser (String accessToken) throws ConnectionException {
        try {
            GooglePojo googlePojo = getUserInfo(accessToken);
            return new Result.Success(googlePojo);
        } catch (IOException e) {
            throw new ConnectionException(e.getMessage());
        }
    }

    private GooglePojo getUserInfo(final String accessToken) throws IOException {
        String link = GOOGLE_LINK_GET_USER_INFO + accessToken;
        Response response = Request.Get(link).execute();
        final GooglePojo[] googlePojo = {null};
        response.handleResponse((httpResponse) -> {
            int status = httpResponse.getStatusLine().getStatusCode();

            if (status == 401) {
                return new Result.AuthError();
            }
            if (status < 200 || status > 299) {
                return new Result.GeneralError();
            }

            // success
            String respBody = response.returnContent().asString();
            MasaLog.normalLog("Json: " + respBody);
            googlePojo[0] = new Gson().fromJson(respBody, GooglePojo.class);
            System.out.println("Google POJO: " + googlePojo[0].getEmail());
            return googlePojo[0];
        });
        return googlePojo[0];
    }
}
