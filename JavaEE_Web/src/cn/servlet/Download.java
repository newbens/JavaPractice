package cn.servlet;

import cn.utils.DownloadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/Download")
public class Download extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取文件名称
        String filename = request.getParameter("filename");

        ServletContext s = this.getServletContext();
        //设置响应头类型
        String mimeType = s.getMimeType(filename);//获取文件mime类型
        response.setHeader("content-type",mimeType);
        //读取文件
        String realPath = s.getRealPath("/music/" + filename);//获取路径
        //关联字节流
        FileInputStream file = new FileInputStream(realPath);

        //解决中文文件名问题
        String header = request.getHeader("user-agent");
        System.out.println(header);
        filename = DownloadUtils.getFileName(header, filename);

        //设置响应头打开方式
        response.setHeader("content-disposition","attachment;filename="+filename);
        ServletOutputStream outputStream = response.getOutputStream();
        byte[] b = new byte[8];
        int len = 0;
        while ((len = file.read(b)) != -1) {
            outputStream.write(b,0,len);
        }
        file.close();


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
