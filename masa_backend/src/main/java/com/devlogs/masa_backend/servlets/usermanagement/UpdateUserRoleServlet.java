//package com.devlogs.masa_backend.servlets.usermanagement;
//
//import com.devlogs.masa_backend.common.helper.MasaLog;
//import com.devlogs.masa_backend.manage.GetAllUserUserCase;
//import com.devlogs.masa_backend.manage.UpdateUserRoleUseCase;
//import com.devlogs.masa_backend.servlets.common.RequestHelper;
//import com.devlogs.masa_backend.servlets.common.ResponseHelper;
//import com.devlogs.masa_backend.servlets.common.base.BaseHttpServlet;
//import com.google.gson.Gson;
//
//import javax.inject.Inject;
//import javax.servlet.*;
//import javax.servlet.http.*;
//import javax.servlet.annotation.*;
//import java.io.IOException;
//
//
//@WebServlet(name = "UpdateUserRoleServlet", value = "/api/user-management/updateuser")
//public class UpdateUserRoleServlet extends BaseHttpServlet {
//
//    @Inject
//    protected UpdateUserRoleUseCase updateUserRoleUseCase;
//
//    @Override
//    public void init() throws ServletException {
//        super.init();
//        getControllerComponent().inject(this);
//    }
//
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        RequestHelper requestHelper = this.getRequestComponent().getRequestHelper();
//        ResponseHelper responseHelper = this.getRequestComponent().getResponseHelper();
//
//        GetAllUserUserCase.Result result = getAllUserUserCase.executes();
//
//        if (result instanceof GetAllUserUserCase.Result.Success) {
//            responseHelper.responseJsonOk(new Gson().toJson(result));
//
//            MasaLog.normalLog("TRueeeeee");
//        } else
//            responseHelper.responseMessage(400,"No user is existed!!!" );
//
//    }
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
//}
