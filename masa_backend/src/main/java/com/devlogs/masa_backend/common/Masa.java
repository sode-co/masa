package com.devlogs.masa_backend.common;

import javax.servlet.ServletContext;

public class Masa {
    public static class Component {
        public static final String APPLICATION_COMPONENT = "APPLICATION_COMPONENT";
    }

        public static String DATABASE_HOST = "";
        public static String DATABASE_NAME = "";
        public static String DATABASE_USER = "";
        public static String DATABASE_PASSWORD = "";

    public static String GOOGLE_CLIENT_SECRET = "";
        public static String GOOGLE_REDIRECT_URI = "http://localhost:8080/masa/logingoogle";
        public static String GOOGLE_LINK_GET_TOKEN = "https://accounts.google.com/o/oauth2/token";
        public static String GOOGLE_LINK_GET_USER_INFO = "https://www.googleapis.com/oauth2/v1/userinfo?access_token=";
        public static String CLIENT_ID = "";
        public static String GOOGLE_GRANT_TYPE = "authorization_code";


    public static void init (ServletContext context) {
        GOOGLE_CLIENT_SECRET = context.getInitParameter("GOOGLE_CLIENT_SECRET");
        CLIENT_ID = context.getInitParameter("GOOGLE_CLIENT_ID");

        DATABASE_HOST = context.getInitParameter("DATABASE_HOST");
        DATABASE_NAME = context.getInitParameter("DATABASE_NAME");
        DATABASE_USER = context.getInitParameter("DATABASE_USER");
        DATABASE_PASSWORD = context.getInitParameter("DATABASE_PASSWORD");
    }

}
