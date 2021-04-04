package cn.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ResponseDemo2")
public class ResponseDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String s = System.getProperty("file.encoding");
//        System.out.println(s);
        //首先设置服务器编码格式
        response.setCharacterEncoding("utf-8");
        //告诉服务器鞭名马格式
        response.setContentType("text-html;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.write("HELLO  There is Demo2<br>");
        pw.write("信息  There is Demo2");
        System.out.println("demo2");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
