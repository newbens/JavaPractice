package cn.web;

import cn.domain.PageBean;
import cn.domain.Staff;
import cn.domain.Teacher;
import cn.service.Imp.StaffServiceImp;
import cn.service.Imp.TeacherServiceImp;
import cn.service.StaffService;
import cn.service.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/findAllTeacher")
public class FindAllTeacher extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> parameterMap = request.getParameterMap();
        //2.调用service
        TeacherService s = new TeacherServiceImp();
        List<Teacher> all = s.findAll();
        //3.存入request
        request.setAttribute("all",all);
        request.getRequestDispatcher("/teacherList.jsp").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
