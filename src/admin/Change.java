package admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Goods;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import utils.DataSourceUtils;


public class Change extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());

        HttpSession session = request.getSession();
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        Connection con = null;
        //这里是获取数据库连接

        try {
            con=DataSourceUtils.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String id = request.getParameter("id");
        Goods x=new Goods();

        String sql = "select * from goods where id=?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        try {
            x =  runner.query(sql, new BeanHandler<Goods>(Goods.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //将动态数组存入session中，方便之后在jsp调用
        session.setAttribute("info", x);
        response.sendRedirect(request.getContextPath() + "/ChangeGoods.jsp");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}