package com.devlogs.masa_backend.common.helper;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvHelper {

    public static Dotenv getEnv (String envFilePath) {
        Dotenv env = Dotenv.configure().directory(envFilePath+"/env").filename("masa.env").ignoreIfMalformed().ignoreIfMissing().load();
        MasaLog.normalLog("Google client id la: " + envFilePath + env.get("GOOGLE_CLIENT_ID"));
        return env;
    }
}
