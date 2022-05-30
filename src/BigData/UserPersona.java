package BigData;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.User;
import utils.DataSourceUtils;


public class UserPersona extends HttpServlet {
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
                switch (kind) {
                    case "电子产品" -> p.addEle();
                    case "服装" -> p.addCloth();
                    case "食品/饮品" -> p.addFood();
                    case "化妆品" -> p.addCosmetic();
                    case "文具" -> p.addStationery();
                    case "日用品" -> p.addDaily();
                    case "图书" -> p.addBook();
                    case "办公" -> p.addOffice();
                    case "乐器" -> p.addMusical();
                    case "其他" -> p.addOthers();
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
        persona.setEle(ele);
        persona.setFood(food);
        persona.setCloth(cloth);
        persona.setCosmetic(cosmetic);
        persona.setStationery(stationery);
        persona.setBook(book);
        persona.setDaily(daily);
        persona.setMusical(musical);
        persona.setOffice(office);
        persona.setOthers(others);
        session.setAttribute("persona", persona);
        session.setAttribute("clientname", name);
        //将动态数组存入session中，方便之后在jsp调用
        response.sendRedirect(request.getContextPath() + "/Persona.jsp");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}