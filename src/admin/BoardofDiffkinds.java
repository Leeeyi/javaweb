package admin;

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
import utils.DataSourceUtils;


public class BoardofDiffkinds extends HttpServlet {
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
        int i = Integer.parseInt(request.getParameter("kind"));
        String kind = new String();
        if(i == 1){ kind = "'电子产品'";}
        else if(i == 2){ kind = "'服装'";}
        else if(i == 3){ kind = "'食品/饮品'";}
        else if(i == 4){ kind = "'化妆品'";}
        else if(i == 5){ kind = "'文具'";}
        else if(i == 6){ kind = "'日用品'";}
        else if(i == 7){ kind = "'图书'";}
        else if(i == 8){ kind = "'办公'";}
        else if(i == 9){ kind = "'乐器'";}
        else if(i == 10){ kind = "'其他'";}
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
        //ArryList为一个动态数组，现在这里它就是一个clas类的数组
        ArrayList<Goods> list = new ArrayList<Goods>();
        Goods x=new Goods();
        Statement stmt;
        ResultSet rsst = null ;
        try {

            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rsst = stmt.executeQuery("select * from goods where kind="+ kind + " order by sellnum desc");
        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }

        try {
            while(rsst.next())

            {
                x=new Goods();
                //将读取到的数据存入该对象中
                x.setName(rsst.getString(2));
                x.setId(rsst.getString(1));
                x.setSellnum(rsst.getInt(7));
                //将赋好值的对象添加入动态数组中
                list.add(x);

            }
        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        //将动态数组存入session中，方便之后在jsp调用
        session.setAttribute("board", list);
        response.sendRedirect(request.getContextPath() + "/Board.jsp");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}