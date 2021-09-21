package com.devlogs.masa_backend.common;

import com.devlogs.masa_backend.common.helper.MasaLog;

import javax.servlet.ServletContext;

public class Masa {
    public static class Component {
        public static final String APPLICATION_COMPONENT = "APPLICATION_COMPONENT";
    }

        public static String SERVER_HOST;

        public static String DATABASE_HOST = "";
        public static String DATABASE_NAME = "";
        public static String DATABASE_USER = "";
        public static String DATABASE_PASSWORD = "";

        public static String GOOGLE_CLIENT_SECRET = "";
        public static String GOOGLE_REDIRECT_URI;
        public static String GOOGLE_LINK_GET_TOKEN = "https://accounts.google.com/o/oauth2/token";
        public static String GOOGLE_LINK_GET_USER_INFO = "https://www.googleapis.com/oauth2/v1/userinfo?access_token=";
        public static String CLIENT_ID = "";
        public static String GOOGLE_GRANT_TYPE = "authorization_code";

        public static class SESSION_KEY {
            public static final String USER = "CURRENT_USER";
        }

        public static class PAGE {
            public static class STUDENT {
                public static String MEETING_PAGE = "student/meeting/index.jsp";
            }
            public static class ADMIN {
                public static String USER_MANAGEMENT_PAGE = "admin/user-management/index.jsp";
            }

            public static class MENTOR {
                public static String MEETING_PAGE = "mentor/meeting/index.jsp";
            }

            public static class GUEST {
                public static String WELCOME = "guest/welcome/index.jsp";
            }
        }

        public static class API {
            public static class MEETING {
                public static String CREATE = "api/meeting/create";
                public static String UPDATE = "api/meeting/update";
            }

            public static class REQUEST {
                public static final String ANSWER_BECOME_MENTOR_REQUEST_NAV = "/api/request-management/answer";
            }
        }
    public static void onServerName (String protocol, String serverName, int port) {
            if (protocol.equals("HTTP/1.1")) {
                SERVER_HOST = "http://"+serverName+":"+port+"/masa";
            }
            MasaLog.normalLog("Server host: " + SERVER_HOST);
            GOOGLE_REDIRECT_URI = "http://localhost:"+port+"/masa/logingoogle";
    }
    public static void init (ServletContext context) {
        GOOGLE_CLIENT_SECRET = context.getInitParameter("GOOGLE_CLIENT_SECRET");
        CLIENT_ID = context.getInitParameter("GOOGLE_CLIENT_ID");

        DATABASE_HOST = context.getInitParameter("DATABASE_HOST");
        DATABASE_NAME = context.getInitParameter("DATABASE_NAME");
        DATABASE_USER = context.getInitParameter("DATABASE_USER");
        DATABASE_PASSWORD = context.getInitParameter("DATABASE_PASSWORD");
    }

}
