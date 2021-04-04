package cn.web;
//************************控制层，得到页面信息，发送到业务逻辑层***************************
import cn.domain.Admin;
import cn.domain.Staff;
import cn.service.Imp.StaffServiceImp;
import cn.service.StaffService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/addStaffServlet")
public class AddStaffServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> parameterMap = request.getParameterMap();
        Staff staff = new Staff();
        try {
            BeanUtils.populate(staff, parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        StaffService s = new StaffServiceImp();
        s.addStaff(staff);
        //添加结束后重定向到界面
        response.sendRedirect(request.getContextPath()+"/staffListServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
