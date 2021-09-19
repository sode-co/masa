package com.devlogs.masa_backend.servlets.test;

import com.devlogs.masa_backend.data.remote_database.MeetingDAO;
import com.devlogs.masa_backend.data.remote_database.MeetingDTO;
import com.devlogs.masa_backend.data.remote_database.PlatformUrlsDAO;
import com.devlogs.masa_backend.data.remote_database.PlatformUrlsDTO;
import com.devlogs.masa_backend.servlets.common.base.BaseHttpServlet;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "TestServlet", urlPatterns = "/TestServlet")
public class TestServlet extends BaseHttpServlet {
    @Inject
    public PlatformUrlsDAO dao;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getControllerComponent().inject(this);

        try {
            PlatformUrlsDTO dto = dao.addNewPlatformUrl("mentorF",1,"link4");
            if(dto!=null){
                //for(MeetingDTO dto : list){
                    System.out.println(dto.toString());
                //}
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
