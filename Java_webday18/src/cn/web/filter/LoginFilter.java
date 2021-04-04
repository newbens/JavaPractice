//package cn.web.filter;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import java.io.IOException;
//
//@WebFilter("/*")
//public class LoginFilter implements Filter {
//    public void destroy() {
//    }
//
//    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
//        //类型强转
//        HttpServletRequest request = (HttpServletRequest) req;
//        //获取请求路径
//        String requestURI = request.getRequestURI();
//        if (requestURI.contains("login.jsp") || requestURI.contains("loginServlet") || requestURI.contains("checkCodeServlet") || requestURI.contains("/css/") || requestURI.contains("/js/") || requestURI.contains("/fonts/")) {
//            chain.doFilter(req,resp);
//        }else {
//            Object admin = request.getSession().getAttribute("admin");
//            if (admin == null) {
//                request.setAttribute("Loginmessage","宁尚未登陆");
//                request.getRequestDispatcher("/login.jsp").forward(req,resp);
//            }else {
//                chain.doFilter(req, resp);
//            }
//        }
//    }
//
//    public void init(FilterConfig config) throws ServletException {
//
//    }
//
//}
