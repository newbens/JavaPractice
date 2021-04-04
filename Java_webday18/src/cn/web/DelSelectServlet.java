package cn.web;

import cn.service.Imp.StaffServiceImp;
import cn.service.StaffService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/delSelectServlet")
public class DelSelectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] uids = request.getParameterValues("uid");
        int[] ids = new int[uids.length];
        for (int i = 0; i <uids.length ; i++) {
            ids[i] = Integer.parseInt(uids[i]);
        }
        StaffService s = new StaffServiceImp();
        s.delSelect(ids);
        response.sendRedirect(request.getContextPath()+"/staffListServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
