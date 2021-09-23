package com.devlogs.masa_backend.domain.ports.sendmail;

import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.errors.TimeOutException;

public interface SendMailGateway {
    boolean sendEmailWithScheduler (Email email, String receiverEmail, Long scheduleMillis) throws ConnectionException, TimeOutException;
    boolean sendEmailNow (Email email, String receiverEmail) throws ConnectionException, TimeOutException;
}
