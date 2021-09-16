package com.devlogs.masa_backend.servlets.user;

import com.devlogs.masa_backend.servlets.common.base.BaseHttpServlet;
import com.devlogs.masa_backend.user.GetUserByEmailUseCase;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GetUserByEmailServlet", urlPatterns = "/getUserByEmail")
public class GetUserByEmailServlet extends BaseHttpServlet {

    @Inject
    public GetUserByEmailUseCase getUserByEmailUseCase;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getControllerComponent().inject(this);
        String emailParam = req.getParameter("email");
        /*
        * Khởi tạo UseCase và truyền vào repository nào mình cần, ở đây mình giả sử là database chưa code xong
        * nên mình sẽ Fake data để code, nên mình truyền vào MockUserRepository, khi nào mà database code xong,
        * mình sẽ đổi nó thành UserRepositoryImp.
        * */
        GetUserByEmailUseCase.Result result = getUserByEmailUseCase.executes(emailParam);
        PrintWriter writer = resp.getWriter();

        /*
         * Để phân biệt result (success, connectionerror, notfound,...)
         * Mình sử dụng phương thức instanceof để kiểm tra kiểu dữ liệu của result
         * Từ đó phân biệt được result với nhau.
         * */
        if (result instanceof GetUserByEmailUseCase.Result.Success ) {
            writer.println("Get user success,"
                    + " email: " + ((GetUserByEmailUseCase.Result.Success) result).getUser().getEmail()
                    + " name: " + ((GetUserByEmailUseCase.Result.Success) result).getUser().getFullName());
        } else if (result instanceof GetUserByEmailUseCase.Result.ConnectionError ) {
            writer.println("Connection error nhaaaaaaaaaaaaa!!!!!");
        } else if (result instanceof GetUserByEmailUseCase.Result.NotFoundError ) {
            writer.println("NotFound error nhaaaaaaaaaaaaa!!!!!");
        } else if (result instanceof GetUserByEmailUseCase.Result.GeneralError ) {
            writer.println("GeneralError error nhaaaaaaaaaaaaa!!!!!: " + ((GetUserByEmailUseCase.Result.GeneralError) result).getMessage());
        }
    }
}
