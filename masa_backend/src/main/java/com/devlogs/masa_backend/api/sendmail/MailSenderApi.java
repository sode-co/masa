package com.devlogs.masa_backend.api.sendmail;

import com.devlogs.masa_backend.common.helper.MasaLog;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.errors.TimeOutException;
import com.devlogs.masa_backend.domain.ports.sendmail.Email;
import com.devlogs.masa_backend.domain.ports.sendmail.SendMailGateway;
import okhttp3.*;
import javax.inject.Inject;
import java.io.IOException;

public class MailSenderApi implements SendMailGateway {
    private final OkHttpClient httpClient;

    @Inject
    public MailSenderApi(OkHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    private Response send (Email email, String receiverEmail, Long scheduleMillis) throws IOException {
        RequestBody formBody = new FormBody.Builder()
                .add("schedule", "" + scheduleMillis)
                .add("to", receiverEmail)
                .add("subject", email.getSubject())
                .add("message", email.getMessage())
                .add("html", email.getHtml())
                .build();
        Request sendMailReq = new Request.Builder()
                .header("Content-Type", "application/json")
                .header("Content-Length", "80000")
                .url("http://localhost:8000/sendmail")
                .post(formBody)
                .build();
            return httpClient.newCall(sendMailReq).execute();
    }

    @Override
    public boolean sendEmailWithScheduler(Email email, String receiverEmail, Long scheduleMillis) throws ConnectionException, TimeOutException {
        try (Response resp = send(email, receiverEmail, scheduleMillis)) {
            return resp.isSuccessful();
        } catch (IOException e) {
            throw new ConnectionException(e.getMessage());
        }
    }

    @Override
    public boolean sendEmailNow(Email email, String receiverEmail) throws ConnectionException, TimeOutException {
        try (Response resp = send(email, receiverEmail, 0L)) {
            MasaLog.normalLog("Send mail result: " + resp.message());
            return resp.isSuccessful();
        } catch (IOException e) {
            throw new ConnectionException(e.getMessage());
        }
    }
}
