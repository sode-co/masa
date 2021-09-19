package com.devlogs.masa_backend.servlets.test;

import com.devlogs.masa_backend.common.helper.MasaLog;
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

@WebServlet(name = "TestServlet", urlPatterns = "/TestServlet")
public class TestServlet extends BaseHttpServlet {
    @Inject
    public UserRepositoryImp imp;
//    @Inject
//    UserDao dao;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getControllerComponent().inject(this);

        try {
        UserRole userRole =  new UserRole(UserRole.TYPE.STUDENT);
        UserStatus userStatus =  new UserStatus(UserStatus.STATUS.ACTIVE);
        UserEntity userEntity = imp.addUser("implementation@fpt.edu.vn", "Im pe men", "url10",
                 userRole, userStatus);
           if (userEntity != null ){
               MasaLog.normalLog("Add thanh cong roi hihi ");
           } else  MasaLog.normalLog("NULLLLL");
        } catch (AlreadyExistException e) {
            e.printStackTrace();
        } catch (ConnectionException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
