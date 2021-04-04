package cn.web;

import cn.domain.PageBean;
import cn.domain.Staff;
import cn.service.Imp.StaffServiceImp;
import cn.service.StaffService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/findStaffByPageServlet")
public class FindStaffByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //1.获取参数
        String currentPage = request.getParameter("currentPage");//获取当前页码
        String rows = request.getParameter("rows");//获取每页显示的条数
        if (currentPage == null) {
            currentPage = "1";
        }
        if (rows == null) {
            rows = "3";
        }
        Map<String, String[]> parameterMap = request.getParameterMap();
        //2.调用service
        StaffService s = new StaffServiceImp();
        PageBean<Staff> pageBean =  s.findStaffPage(currentPage,rows,parameterMap);
        //3.存入request
        request.setAttribute("pb",pageBean);
        request.setAttribute("pm",parameterMap);
        request.getRequestDispatcher("/list.jsp").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
