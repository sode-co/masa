package com.devlogs.masa_backend.domain.ports.sendmail;

public interface Email {
    String getSubject ();
    String getHtml();
    String getMessage();
}
