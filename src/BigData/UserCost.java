package BigData;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.User;
import utils.DataSourceUtils;


public class UserCost extends HttpServlet {
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
        String id =request.getParameter("id");
        String name = request.getParameter("name");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        Connection con = null;
        //这里是获取数据库连接

        try {
            con=DataSourceUtils.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Bean.Persona p = new Bean.Persona();
        Statement stmt;
        ResultSet rsst = null ;
        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rsst = stmt.executeQuery("select * from orderbigdata where userid=" + id);
        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }

        try {
            while(rsst.next())
            {
                String kind = rsst.getString(2);
                Double cost = Double.valueOf(rsst.getString(4));
                switch (kind) {
                    case "电子产品" -> p.addEle1(cost);
                    case "服装" -> p.addCloth1(cost);
                    case "食品/饮品" -> p.addFood1(cost);
                    case "化妆品" -> p.addCosmetic1(cost);
                    case "文具" -> p.addStationery1(cost);
                    case "日用品" -> p.addDaily1(cost);
                    case "图书" -> p.addBook1(cost);
                    case "办公" -> p.addOffice1(cost);
                    case "乐器" -> p.addMusical1(cost);
                    case "其他" -> p.addOthers1(cost);
                }
            }
        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        double sum = p.getEle() + p.getCloth() + p.getFood() + p.getCosmetic() + p.getStationery() + p.getDaily() + p.getBook()
                + p.getOffice() + p.getMusical() + p.getOthers();
        double ele = p.getEle() / sum;
        double cloth = p.getCloth() / sum;
        double food = p.getFood() / sum;
        double cosmetic = p.getCosmetic() / sum;
        double stationery = p.getStationery() /sum;
        double daily = p.getDaily() / sum;
        double book = p.getBook() / sum;
        double office = p.getOffice() / sum;
        double musical = p.getMusical() / sum;
        double others = p.getOthers() / sum;
        Bean.Persona persona = new Bean.Persona();
        Bean.Persona cost = new Bean.Persona();
        DecimalFormat df = new DecimalFormat("#.000");
        cost.setEle(Double.parseDouble(df.format(p.getEle())));
        cost.setCloth(Double.parseDouble(df.format(p.getCloth())));
        cost.setFood(Double.parseDouble(df.format(p.getFood())));
        cost.setCosmetic(Double.parseDouble(df.format(p.getCosmetic())));
        cost.setStationery(Double.parseDouble(df.format(p.getStationery())));
        cost.setDaily(Double.parseDouble(df.format(p.getDaily())));
        cost.setBook(Double.parseDouble(df.format(p.getBook())));
        cost.setOffice(Double.parseDouble(df.format(p.getOffice())));
        cost.setMusical(Double.parseDouble(df.format(p.getMusical())));
        cost.setOthers(Double.parseDouble(df.format(p.getOthers())));
        persona.setEle(Double.parseDouble(df.format(ele)));
        persona.setFood(Double.parseDouble(df.format(food)));
        persona.setCloth(Double.parseDouble(df.format(cloth)));
        persona.setCosmetic(Double.parseDouble(df.format(cosmetic)));
        persona.setStationery(Double.parseDouble(df.format(stationery)));
        persona.setBook(Double.parseDouble(df.format(book)));
        persona.setDaily(Double.parseDouble(df.format(daily)));
        persona.setMusical(Double.parseDouble(df.format(musical)));
        persona.setOffice(Double.parseDouble(df.format(office)));
        persona.setOthers(Double.parseDouble(df.format(others)));
        session.setAttribute("persona", persona);
        session.setAttribute("cost", cost);
        session.setAttribute("clientname", name);
        //将动态数组存入session中，方便之后在jsp调用
        response.sendRedirect(request.getContextPath() + "/Usercost.jsp");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}