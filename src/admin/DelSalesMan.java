package admin;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Bean.User;
import service.UserService;
/**
 * 购物车内容变更
 * @author admin
 *
 */
public class DelSalesMan extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        UserService service = new UserService();
        // 调用service完成添加商品操作
        service.deleteUser(id);
        HttpSession session = request.getSession();
        ArrayList<User> g = (ArrayList<User>) session.getAttribute("salesmanlist");
        for(int i=0;i<g.size();i++) {
            if(Objects.equals(g.get(i).getId(), id))
            {
                g.remove(i);
            }
        }
        session.setAttribute("salesmanlist", g);
        response.sendRedirect(request.getContextPath() + "/AdminSalesMan.jsp");
    }
}
