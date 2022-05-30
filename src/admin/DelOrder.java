package admin;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Bean.Order;
import service.OrderService;
/**
 * 购物车内容变更
 * @author admin
 *
 */
public class DelOrder extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        OrderService service = new OrderService();
        // 调用service完成添加商品操作
        service.delOrder(id);
        HttpSession session = request.getSession();
        ArrayList<Order> g = (ArrayList<Order>) session.getAttribute("order");
        for(int i=0;i<g.size();i++) {
            if(Objects.equals(g.get(i).getId(), id))
            {
                g.remove(i);
            }
        }
        session.setAttribute("order", g);
        response.sendRedirect(request.getContextPath() + "/Admin_Order.jsp");

    }
}
