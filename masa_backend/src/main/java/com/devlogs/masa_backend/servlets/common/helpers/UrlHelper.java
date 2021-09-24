package com.devlogs.masa_backend.servlets.common.helpers;

public class UrlHelper {

    public static String minimizeUrl (String url) {
        String result = url;
        char[] urls = url.toCharArray();
        for (char c : urls) {
            if (c == '/') {
                result = url.replaceFirst("/", "");
                continue;
            } else {
                break;
            }
        }

        result = result.replaceAll("\\/\\*$", "");

        return result;
    }

    public static String getResourceUrl (String url) {
        String resource = url.replace("/masa", "");
        resource = minimizeUrl(resource);
        return resource;
    }
}
