package BigData;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Goods;
import Bean.User;
import Bean.UserBigData;
import utils.DataSourceUtils;


public class LogTime extends HttpServlet {
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
        UserBigData bigdata = new UserBigData();
        ArrayList<UserBigData> list = new ArrayList<UserBigData>();
        Statement stmt;
        ResultSet rsst = null ;
        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rsst = stmt.executeQuery("select * from userBigdata");
        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }

        try {
            while(rsst.next())
            {
                bigdata = new UserBigData();
                bigdata.setId(rsst.getString(1));
                bigdata.setName(rsst.getString(2));
                bigdata.setLoginTime(rsst.getString(3));
                bigdata.setLogoutTime(rsst.getString(4));
                bigdata.setIp(rsst.getString(5));
                list.add(bigdata);
                }
            } catch (SQLException ex) {
            ex.printStackTrace();
        }
        session.setAttribute("logtime", list);
        //将动态数组存入session中，方便之后在jsp调用
        response.sendRedirect(request.getContextPath() + "/LogTime.jsp");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}