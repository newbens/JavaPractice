package cn.web;

import cn.domain.Staff;
import cn.domain.Teacher;
import cn.service.Imp.StaffServiceImp;
import cn.service.Imp.TeacherServiceImp;
import cn.service.StaffService;
import cn.service.TeacherService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/updateTeacherServlet")
public class UpdateTeacherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        Map<String, String[]> parameterMap = request.getParameterMap();
        Teacher teacher = new Teacher();
        try {
            BeanUtils.populate(teacher,parameterMap);//一一更新
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        TeacherService teacherService = new TeacherServiceImp();
        teacherService.UpdateTeacher(teacher);
        response.sendRedirect(request.getContextPath()+"/findAllTeacher");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
