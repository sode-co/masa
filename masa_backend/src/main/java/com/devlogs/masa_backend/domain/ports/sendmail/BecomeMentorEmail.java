package com.devlogs.masa_backend.domain.ports.sendmail;

import com.devlogs.masa_backend.common.Masa;

public class BecomeMentorEmail implements Email{
    private final String HTML_TEMPLATE = "<!DOCTYPE html><html lang=\"en\"><head>    <meta charset=\"UTF-8\">    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">    <title>Become mentor</title></head><body>    <h1>BECOME MENTOR</h1> Dear admin, <br/>    <br/> I want to become a mentor in your platform, here is my meeting platform info:    <h4>ZOOM <a href=\"_zoom_link\">link</a> </h4>    <h4>GOOGLE MEET <a href=\"_meet_link\">link</a></h4> And here is my information: <br/>    <br/> FULLNAME: <b>_user_fullname</b> <br/> EMAIL:<b>_user_email</b> <br/> UserID: <b>_user_id</b><br/> USER DESCRIPTION: <b>_user_description</b><br/>    <br/>I'm looking forward to here your response, you can answer my request from <a href='_request_link'>here</a> <br/> Thanks, <br/> <i>Sent from guest.soma.autosend</i></body></html>";
    private String subject;
    private String html;

    public BecomeMentorEmail(String zoomUrl, String googleMeetUrl, String userEmail, String userId, String userFullName, String userDescription, String requestId) {
        this.subject = "I want to become mentor";
        html = HTML_TEMPLATE.replace("_zoom_link", zoomUrl);
        html = html.replace("_meet_link", googleMeetUrl);
        html = html.replace("_user_email", userEmail);
        html = html.replace("_user_description", userDescription);
        html = html.replace("_user_id", userId);
        html = html.replace("_user_fullname", userFullName);
        html = html.replace("_request_link", getRequestUrl(requestId, userId, userFullName));
    }

    private String getRequestUrl(String id, String userId, String fullName) {
        return Masa.SERVER_HOST + String.format(
                "/admin/request-management/response/index.jsp" +
                        "?id=%s" +
                        "&userId=%s" +
                        "&fullName=%s", id, userId, fullName);
    }

    @Override
    public String getSubject() {
        return subject;
    }

    @Override
    public String getHtml() {
        return html;
    }

    @Override
    public String getMessage() {
        return "";
    }
}
