package com.devlogs.masa_backend.servlets.common;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseHelper {

    private HttpServletResponse currentResponse;

    public ResponseHelper(HttpServletResponse currentResponse) throws IOException {
        this.currentResponse = currentResponse;
    }

    public HttpServletResponse getCurrentResponse() {
        return currentResponse;
    }

    public void responseJson (int status, String json) throws IOException {
        currentResponse.setContentType("application/json;charset=utf-8");
        currentResponse.setCharacterEncoding("utf-8");
        currentResponse.setStatus(status);
        PrintWriter printWriter = currentResponse.getWriter();
        printWriter.print(json);
        printWriter.flush();
    }

    public void responseJsonOk (String json) throws IOException {
        responseJson(200, json);
    }

    public void responseMessage (int status, String message) throws IOException {
        currentResponse.setContentType("text/plain;charset=utf-8");
        currentResponse.setStatus(status);
        PrintWriter printWriter = currentResponse.getWriter();
        printWriter.write(message);
        printWriter.flush();
    }
}
