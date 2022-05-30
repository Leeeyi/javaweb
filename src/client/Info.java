package client;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exception.RegisterException;
import Bean.Order;
import Bean.Goods;
import Bean.User;
import Bean.OrderBigdata;
import service.BigDataService;
import service.OrderService;
import service.UserService;
//生成订单
public class Info extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 1.得到当前用户
        HttpSession session = request.getSession();
        User user = (User) request.getSession().getAttribute("user");
        String id = user.getId();
        // 2.从购物车中获取商品信息
        ArrayList<Goods> cart = (ArrayList<Goods>)session.getAttribute("cart");
        // 3.将数据封装到订单对象中
        Order order = new Order();
        order.setAddress(request.getParameter("address"));
        order.setName(request.getParameter("name"));
        order.setPhone(request.getParameter("phone"));
        order.setUser(user);// 封装用户信息到订单.
        order.setGoods(cart);
        for(int i = 0 ; i < cart.size() ; i ++){
            order.setGoodsName(cart.get(i).getName());
            order.setSalesmanidofgoods(cart.get(i).getIdofsalesman());
            OrderService service = new OrderService();
            service.addOrder(order);
        }

        //大数据订单信息
        response.setContentType("text/html;charset=UTF-8");
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(date);
        OrderBigdata bigdata = new OrderBigdata();
        for(int i = 0 ; i < cart.size() ; i ++){
            bigdata.setKind(cart.get(i).getKind());
            bigdata.setPrice(cart.get(i).getPrice());
            bigdata.setId(id);
            bigdata.setDate(currentDate);
            BigDataService service = new BigDataService();
            try {
                service.addOrderBigdata(bigdata);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        String GoodsName = new String();
        for(int i = 0 ; i < cart.size() ; i ++){
            if(i != cart.size() - 1){
                GoodsName += cart.get(i).getName() + " / ";
            }
            else{GoodsName += cart.get(i).getName();}
        }
        order.setGoodsName(GoodsName);
        UserService userService = new UserService();
        try {
            userService.Mail(user, order);
        } catch (RegisterException e) {
            e.printStackTrace();
        }
        response.sendRedirect(request.getContextPath() + "/CreateOrderSuccess.jsp");
    }

}
