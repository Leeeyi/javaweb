package client;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;

import Bean.User;
import service.UserService;
import exception.RegisterException;

public class Register extends HttpServlet {
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
        user.setGender(request.getParameter("gender"));
        user.setEmail(request.getParameter("email"));
        user.setTelephone(request.getParameter("telephone"));
        user.setRole("client");
        // 调用service完成注册操作。
        UserService service = new UserService();
        try {
            service.register(user);
        } catch (RegisterException e) {
            e.printStackTrace();
            response.getWriter().write(e.getMessage());
        }
        response.sendRedirect(request.getContextPath() + "/registersuccess.jsp");
    }
}
