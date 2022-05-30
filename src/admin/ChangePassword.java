package admin;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;
import java.lang.reflect.InvocationTargetException;
import org.apache.commons.beanutils.BeanUtils;
import Bean.User;
import service.UserService;
import exception.AddGoodsException;

public class ChangePassword extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = new User();
        user.setName(request.getParameter("name"));
        user.setPassword(request.getParameter("password"));
        user.setId(request.getParameter("id"));
        // 调用service完成注册操作。
        UserService service = new UserService();
        service.editPasswd(user);
        response.sendRedirect(request.getContextPath() + "/UserAddSuccess.jsp");
    }
}
