package cn.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/requestdemo2")
public class RequestDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getMethod();
        String cp = request.getContextPath();
        String sp = request.getServletPath();
        String uri = request.getRequestURI();
        StringBuffer url = request.getRequestURL();
        System.out.println(method+"\n"+cp+"\n"+sp+"\n"+uri+"\n"+url);

    }
}
