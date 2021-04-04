package cn.web;

import cn.domain.Staff;
import cn.service.Imp.StaffServiceImp;
import cn.service.StaffService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/staffListServlet")
public class StaffListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用StaffService进行查询
        StaffService s = new StaffServiceImp();
        List<Staff> staffall = s.findAll();
        //存入request域
        request.setAttribute("staffall",staffall);
        request.getRequestDispatcher("list.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
