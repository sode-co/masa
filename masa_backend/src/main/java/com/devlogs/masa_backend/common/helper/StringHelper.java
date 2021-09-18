package com.devlogs.masa_backend.common.helper;

public class StringHelper {

    public static String getSubStringBetween (String main, String str1, String str2) {
        return main.substring(main.lastIndexOf(str1)+str1.length(), main.lastIndexOf(str2)-1);
    }
}
