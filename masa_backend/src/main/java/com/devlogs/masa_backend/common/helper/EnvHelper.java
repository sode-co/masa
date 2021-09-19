package com.devlogs.masa_backend.common.helper;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvHelper {

    public static Dotenv getEnv (String realPath) {
        Dotenv env = Dotenv.configure().directory(realPath+"/.env/..env").ignoreIfMalformed().ignoreIfMissing().load();
        MasaLog.normalLog("Google client id la: " + realPath + env.get("GOOGLE_CLIENT_ID"));
        return env;
    }
}
