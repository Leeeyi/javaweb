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
import Bean.Goods;
import service.GoodsService;
import exception.AddGoodsException;

public class ChangeGoods extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Goods goods = new Goods();
        goods.setName(request.getParameter("name"));
        goods.setPrice(request.getParameter("price"));
        goods.setNum(Integer.parseInt(request.getParameter("num")));
        goods.setDescription(request.getParameter("description"));
        goods.setId(request.getParameter("id"));
        goods.setKind(request.getParameter("kind"));
        // 调用service完成注册操作。
        GoodsService service = new GoodsService();
        service.editProduct(goods);
        response.sendRedirect(request.getContextPath() + "/AddSuccess.jsp");
    }
}
