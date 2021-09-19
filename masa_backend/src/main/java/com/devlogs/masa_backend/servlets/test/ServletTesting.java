package com.devlogs.masa_backend.servlets.test;

import com.devlogs.masa_backend.common.helper.MasaLog;
import com.devlogs.masa_backend.data.remote_database.UserDao;
import com.devlogs.masa_backend.data.remote_database.UserDto;
import com.devlogs.masa_backend.domain.errors.AlreadyExistException;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.servlets.common.base.BaseHttpServlet;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletTesting", value = "/ServletTesting")
public class ServletTesting extends BaseHttpServlet {

    @Inject
    public UserDao dao;

    @Override
    public void init() throws ServletException {
        getControllerComponent().inject(this);
        super.init();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try {

            UserDto dto = dao.addUser("hkk1nguyefdsfnthfkli@fpt.edu.vn", "Nguyensfdasfaf Khagdfgng", "url10",
                    2, 2);

//              UserRepositoryImp user = new UserRepositoryImp();
//            UserEntity userEntity = user.getUserById("SE100001");


//          dao.getUserByEmail("duongnvSE100004@fpt.edu.vn");

            if( dto != null){
                MasaLog.normalLog(dto.toString());
            }
            else MasaLog.normalLog("klsdjfla");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (AlreadyExistException e) {
            e.printStackTrace();
        } catch (ConnectionException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }
}
