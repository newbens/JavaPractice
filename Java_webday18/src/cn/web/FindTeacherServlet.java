package cn.web;

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

@WebServlet("/findTeacherServlet")
public class FindTeacherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        TeacherService teacherService = new TeacherServiceImp();
        Teacher teacher = teacherService.findTeacherById(Integer.valueOf(id));
        request.setAttribute("teacher",teacher);
        request.getRequestDispatcher("/teacherUpdate.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
