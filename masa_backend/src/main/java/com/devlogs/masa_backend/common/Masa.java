package com.devlogs.masa_backend.common;

import com.devlogs.masa_backend.common.helper.EnvHelper;
import com.devlogs.masa_backend.common.helper.MasaLog;
import io.github.cdimascio.dotenv.Dotenv;

import javax.servlet.ServletContext;

public class Masa {
    public static String AUTH_MODE = "CHECK";

    public static class Component {
        public static final String APPLICATION_COMPONENT = "APPLICATION_COMPONENT";
    }

        public static String ICON_URL = "https://cdn-icons-png.flaticon.com/512/2370/2370279.png";

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

        public static class COOKIE {
            public static final String GOOGLE_ACCESS_TOKEN = "GOOGLE_ACCESS_TOKEN";
        }

        public static class PAGE {

            public static class AUTH {
                public static class PERMISSION_MANAGEMENT {
                    public static final String DENIED_PAGE = "auth/permission-management/permission-denied/index.jsp";
                }
            }
            public static class MEMBER {
                public static final String HOME = "member/home.jsp";
                public static String MENTOR_REQUEST = "member/registermentor.jsp";
            }
            public static class ADMIN {
                public static class REQUEST_MANAGEMENT {
                    public static String RESPONSE = "admin/request-management/response/index.jsp";
                }
                public static String MEMBER_MANAGEMENT = "admin/management/student.html";
                public static String MEETING_MANAGEMENT = "admin/manage_meeting.jsp";
            }

            public static class MENTOR {
                public static String MEETING_PAGE = "mentor/meeting/mymeeting.jsp";
                public static String MEETING_CREATE = "mentor/meeting/createnewmeeting.jsp";
                public static String MEETING_UPDATE = "mentor/meeting/updatemeeting.jsp";
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
                SERVER_HOST = "http://"+serverName;
                if (port != 80) {
                    SERVER_HOST += ":"+port+"/masa";
                }
                MasaLog.normalLog("Server host: " + SERVER_HOST);
                GOOGLE_REDIRECT_URI = SERVER_HOST + "/logingoogle";
        }

        public static void init (ServletContext context, String webInfPath) {
            Dotenv env = io.github.cdimascio.dotenv.Dotenv.configure().directory(webInfPath+"/env/.env").ignoreIfMalformed().ignoreIfMissing().load();
            AUTH_MODE = env.get("AUTH");
            GOOGLE_CLIENT_SECRET = env.get("GOOGLE_CLIENT_SECRET");
            MasaLog.normalLog("Auth mode: " + AUTH_MODE);
            CLIENT_ID = env.get("GOOGLE_CLIENT_ID");
            DATABASE_HOST = env.get("DATABASE_HOST");
            DATABASE_NAME = env.get("DATABASE_NAME");
            DATABASE_USER = env.get("DATABASE_USER");
            DATABASE_PASSWORD = env.get("DATABASE_PASSWORD");
        }

}
