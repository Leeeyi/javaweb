package client;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import Bean.UserBigData;
import exception.AddGoodsException;
import service.BigDataService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDate = sdf.format(date);
        UserBigData bigdata = (UserBigData) request.getSession().getAttribute("userBigdata");
        bigdata.setLogoutTime(currentDate);
        BigDataService service = new BigDataService();
        try {
            service.addUserBigdata(bigdata);
        } catch (AddGoodsException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 获取session对象.
        HttpSession session = request.getSession();
        // 销毁session
        session.invalidate();
        // flag标识
        String flag = request.getParameter("flag");
        if (flag == null || flag.trim().isEmpty()) {
            // 重定向到首页
            response.sendRedirect(request.getContextPath() + "/index");
        }
    }
}