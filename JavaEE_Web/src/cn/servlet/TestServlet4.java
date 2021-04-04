package cn.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/TestServlet4")
public class TestServlet4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String) request.getParameter("username");
        String password = (String) request.getParameter("password");
        System.out.println(username +" "+ password);
        if ("niuben".equals(username) && "nn8221002**.-".equals(password)) {
            response.sendRedirect(request.getContextPath()+"/succ.jsp");
        }else {
            request.setAttribute("error","用户名或密码错误！");
            request.getRequestDispatcher("/Login2.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
