package cn.servlet;

import cn.domain.User;
import cn.service.UserService;
import cn.service.serviceImp.UserServiceImp;
import com.fasterxml.jackson.databind.ObjectMapper;
import sun.font.TrueTypeFont;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        //调用service层查询
        UserService us = new UserServiceImp();
        Boolean aBoolean = us.selectUser(username);
        Map<String, Object> map = new HashMap<String, Object>();
        if (aBoolean) {  //代表没有存在
            map.put("exist",true);
            map.put("msg","用户名可用");
        }else {
            map.put("exist",false);
            map.put("msg","用户名不可用");
        }
        //Map转Json
        ObjectMapper o = new ObjectMapper();
        o.writeValue(response.getWriter(),map);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
