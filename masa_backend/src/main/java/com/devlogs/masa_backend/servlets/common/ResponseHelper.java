package com.devlogs.masa_backend.servlets.common;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseHelper {

    private HttpServletResponse currentResponse;
    private PrintWriter printWriter;

    public ResponseHelper(HttpServletResponse currentResponse) throws IOException {
        this.currentResponse = currentResponse;
        this.printWriter = currentResponse.getWriter();
    }

    public HttpServletResponse getCurrentResponse() {
        return currentResponse;
    }

    public void responseJson (int status, String json) {
        currentResponse.setContentType("application/json");
        currentResponse.setCharacterEncoding("UTF-8");
        currentResponse.setStatus(status);
        printWriter.print(json);
        printWriter.flush();
    }

    public void responseJsonOk (String json) {
        responseJson(200, json);
    }

    public void responseMessage (int status, String message) {
        currentResponse.setContentType("application/text");
        currentResponse.setCharacterEncoding("UTF-8");
        currentResponse.setStatus(status);
        printWriter.print(message);
        printWriter.flush();
    }
}
