package com.devlogs.masa_backend.common.helper;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MasaLog {
    public static final String LOGGER_NAME = "MASA_LOG";

    public static void normalLog (String message) {
        Logger.getLogger(LOGGER_NAME).log(Level.INFO, message);
    }

    public static void warningLog (String message) {
        Logger.getLogger(LOGGER_NAME).log(Level.WARNING, message);
    }
}
