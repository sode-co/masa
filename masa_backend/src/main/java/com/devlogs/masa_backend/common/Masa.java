package com.devlogs.masa_backend.common;

import com.devlogs.masa_backend.common.helper.EnvHelper;
import io.github.cdimascio.dotenv.Dotenv;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Masa {
    public static class Component {
        public static final String APPLICATION_COMPONENT = "APPLICATION_COMPONENT";
    }

        public static String GOOGLE_CLIENT_SECRET = "E0JTFqhxd-8vqtrsQPdKwAC0";
        public static String GOOGLE_REDIRECT_URI = "http://localhost:8080/masa/logingoogle";
        public static String GOOGLE_LINK_GET_TOKEN = "https://accounts.google.com/o/oauth2/token";
        public static String GOOGLE_LINK_GET_USER_INFO = "https://www.googleapis.com/oauth2/v1/userinfo?access_token=";
        public static String CLIENT_ID = "608219007311-1f1l4barukaffu78oh3gqsadm865ci6p.apps.googleusercontent.com";
        public static String GOOGLE_GRANT_TYPE = "authorization_code";


    public static void init (String envPath) {
    }

}
