package cn.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/scd1")
public class ServletContextDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext s1 = req.getServletContext();
        ServletContext s2 = this.getServletContext();
        System.out.println(s1 == s2);
        System.out.println(s1);
        System.out.println(s2);
        String s = "s.jpg";
        ServletContext s3 = req.getServletContext();
        String mimeType = s3.getMimeType(s);
        System.out.println(mimeType);
        String realPath = s3.getRealPath("a.txt");
        System.out.println(realPath);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost");
    }
}
