package Dao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Path extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");//编码方式
        resp.setContentType("text/html");//设置为html格式
        PrintWriter writer = resp.getWriter();
        String imgurl_parent = "/Imgs";
        writer.write(String.valueOf(this.getServletContext().getContextPath()));
        String path=this.getServletContext().getRealPath("");
        writer.write(path);
    }

}
