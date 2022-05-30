package client;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Bean.Goods;
import exception.FindGoodsByIdException;
import service.GoodsService;
/**
 * 购物车内容变更
 * @author admin
 *
 */
public class DelCart extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 1.得到商品id
        String id = request.getParameter("id");
        // 2.从session中获取购物车.
        GoodsService service = new GoodsService();
        HttpSession session = request.getSession();
        ArrayList<Goods> cart = (ArrayList<Goods>) session.getAttribute("cart");
        for(int i=0;i<cart.size();i++) {
            if(Objects.equals(cart.get(i).getId(), id))
            {
                cart.remove(i);
            }
        }
        session.setAttribute("cart", cart);
        response.sendRedirect(request.getContextPath() + "/cart.jsp");
    }
}
