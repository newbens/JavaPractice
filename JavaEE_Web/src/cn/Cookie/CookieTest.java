package cn.Cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/CookieTest")
public class CookieTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName());
        }
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if (name.equals("niuben")) {
                    String value = cookie.getValue();
                    //获取当前时间
                    response.getWriter().write("欢迎回来！宁上次的访问时间是"+value);
                    cookie.setValue(getTime());
                    cookie.setMaxAge(-1);
                    response.addCookie(cookie);
                    return;
                }
            }
        }

        Cookie c = new Cookie("niuben",getTime());
        c.setMaxAge(-1);
        response.addCookie(c);
        response.getWriter().write("欢迎宁首次访问！");
    }

    protected String getTime() {
        Date date = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss");
        String format = s.format(date);
        return format;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
