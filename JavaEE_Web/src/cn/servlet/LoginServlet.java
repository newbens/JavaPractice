package cn.servlet;

import cn.domain.User;
import dao.UserDao333;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //获取所有请求参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        //获取验证码
        HttpSession session = request.getSession();
        String check = (String) session.getAttribute("check");
        //为了保证安全，验证码一旦获取就要删除
        session.removeAttribute("check");
        //判断验证码是否正确
        if (check != null && check.equals(request.getParameter("check"))) {
            UserDao333 ud = new UserDao333();
            User loginUser = new User();
            //使用BeanUtils封装
            try {
                BeanUtils.populate(loginUser,parameterMap);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

            User user = ud.userLogin(loginUser);
            if (user == null) {
                //登陆失败.跳转失败页面
                request.setAttribute("l","账户或密码错误！");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            } else {
                //登陆成功 存储数据
                request.setAttribute("user", user.getUsername());
                request.getRequestDispatcher("/succ.jsp").forward(request, response);
            }

        }else{//验证码错误
            request.setAttribute("c","验证码输入错误！");
            request.getRequestDispatcher("/login.jsp").forward(request,response);//转发

        }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
