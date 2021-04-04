package com.niuben.controller;


import com.niuben.domian.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
@RequestMapping("/springmvc")
public class ControllerTest {
    //*********************************返回值类型*************************************

    /**
     * 返回String
     * @param model
     * @return
     */
    @RequestMapping("/testString")
    public String testString(Model model) {
        System.out.println();
        User user = new User();
        user.setUsername("牛犇");
        user.setPassword("nn8221002**.-");
        user.setAge(22);
        //存储
        model.addAttribute("user", user);
        return "success";
    }

    /**
     * 返回void
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //请求转发
        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);
        //重定向
        response.sendRedirect(request.getContextPath()+"/WEB-INF/pages/success.jsp");
        //直接响应
        response.getWriter().write("55555");
        return;
    }

    /**
     * 返回ModelAndView对象
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        ModelAndView m = new ModelAndView();
        User user = new User();
        user.setUsername("张三");
        user.setPassword("123456");
        user.setAge(22);
        //ModelAndValue会将数据存入到request域中
        m.addObject("key",user);
        //跳转路径  自动选择视图解析器
        m.setViewName("success");
        return m;
    }

    @RequestMapping("testForwardOrRedirect")
    public String testForwardOrRedirect(){
        System.out.println("ForwardOrRedirect执行了");
        //关键字的方式转发
//        return "forward:/WEB-INF/pages/success.jsp";
        //重定向
        return "redirect:/success.jsp"; //这里不需要加项目名，因为底层已经加上了
    }


    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user){
        //模拟异步请求
        System.out.println("testAjax执行了");
        //这里想要把json直接封装进对象需要导入三个包，jackson--等
        System.out.println(user);
        user.setUsername("哈哈");
        user.setAge(60);
        //响应
        return user;
    }
}

