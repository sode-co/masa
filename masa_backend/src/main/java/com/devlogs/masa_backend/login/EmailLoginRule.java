package com.devlogs.masa_backend.login;

import com.devlogs.masa_backend.common.helper.MasaLog;

import javax.inject.Inject;

public class EmailLoginRule {

    @Inject
    public EmailLoginRule () {

    }

    public boolean valid (String email) {
        String domain = email.substring(email.indexOf("@")+1);
        MasaLog.normalLog("domain: " + domain);
        return domain.equals("fpt.edu.vn") || domain.equals("fe.edu.vn");
    }
}
