package com.devlogs.masa_backend.servlets.login;

public class GoogleLoginState {
    private String redirectUrl;

    public GoogleLoginState () {

    }

    public GoogleLoginState(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }
}
