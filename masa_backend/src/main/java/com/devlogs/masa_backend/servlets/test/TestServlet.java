package com.devlogs.masa_backend.servlets.test;

import com.devlogs.masa_backend.become_mentor.SendRequestToBecomeMentorUseCase;
import com.devlogs.masa_backend.common.helper.MasaLog;
import com.devlogs.masa_backend.data.remote_database.UserDao;
import com.devlogs.masa_backend.data.remote_database.UserDto;
import com.devlogs.masa_backend.domain.entities.UserEntity;
import com.devlogs.masa_backend.domain.entities.UserRole;
import com.devlogs.masa_backend.domain.entities.UserStatus;
import com.devlogs.masa_backend.domain.errors.AlreadyExistException;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.repository.user.UserRepositoryImp;
import com.devlogs.masa_backend.servlets.common.base.BaseHttpServlet;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "TestServlet", urlPatterns = "/TestServlet")
public class TestServlet extends BaseHttpServlet {
    @Inject
    UserDao dao;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getControllerComponent().inject(this);

//        try {
//            UserDto dto = dao.updateUserRole("SE100003",1);
//            if (list != null) {
//                for (UserDto dto : list){
//                    System.out.println(dto);
//                }
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
