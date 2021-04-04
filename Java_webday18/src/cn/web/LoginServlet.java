package cn.web;

import cn.domain.Admin;
import cn.service.Imp.StaffServiceImp;
import cn.service.StaffService;
import com.mysql.cj.Session;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //设置编码
//        request.setCharacterEncoding("utf-8");
//        //获取验证码并校验
//        String verifycode = request.getParameter("verifycode");
//        HttpSession session = request.getSession();
//        String checkcode_server = (String)session.getAttribute("CHECKCODE_SERVER");
//        if (checkcode_server.equalsIgnoreCase(verifycode)) {
//            //验证码验证成功！开始验证身份
//            Map<String, String[]> parameterMap = request.getParameterMap();
//            try {
//                BeanUtils.populate(admin,parameterMap);
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            } catch (InvocationTargetException e) {
//                e.printStackTrace();
//            }
            //调用service验证身份
//            Admin admin = new Admin();
//            admin.setUser(request.getParameter("username"));
//            admin.setPassword(request.getParameter("password"));
//            StaffService staffService = new StaffServiceImp();
//            Admin login = staffService.login(admin);
//            session.setAttribute("admin",admin);
//            if (login != null) {
                response.sendRedirect(request.getContextPath()+"/findAllTeacher");
//            }else {
//                request.setAttribute("loginfail","账户已存在！");
//            }
//
//        }else {
//            //验证失败
//            request.setAttribute("fail","验证码错误！");
//            request.getRequestDispatcher("/login.jsp").forward(request,response);
//        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
