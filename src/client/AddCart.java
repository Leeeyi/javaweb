package client;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Bean.Goods;
import exception.FindGoodsByIdException;
import service.GoodsService;

public class AddCart extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    @SuppressWarnings("unchecked")
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 1.得到商品id
        String id = request.getParameter("id");
        // 2.调用service层方法，根据id查找商品
        GoodsService service = new GoodsService();
        try {
            Goods goods = service.findGoodsById(id);
            //3.将商品添加到购物车
            //3.1获得session对象
            HttpSession session = request.getSession();
            //3.2从session中获取购物车对象
            ArrayList<Goods> cart = (ArrayList<Goods>)session.getAttribute("cart");
            //3.3如果购物车为null,说明没有商品存储在购物车中，创建出购物车
            if (cart == null) {
                cart = new ArrayList<Goods>();
                session.setAttribute("cart", cart);
            }
            //3.4向购物车中添加商品
            cart.add(goods);
            //3.5如果商品数量不为空，则商品数量+1，否则添加新的商品信息////////////////////

            session.setAttribute("cart", cart);
            response.sendRedirect(request.getContextPath() + "/Browse.jsp");
        } catch (FindGoodsByIdException e) {
            e.printStackTrace();
        }
    }
}