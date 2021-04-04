package cn.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/checkcode")
public class CheckCode extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int w = 100;
        int h = 50;
        //创建图片对象
        BufferedImage bf = new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);
        //画图
        Graphics graphics = bf.getGraphics();//获取画笔对象
        graphics.setColor(Color.PINK);
        graphics.fillRect(0,0,w,h);
        graphics.setColor(Color.BLACK);
        String num = String.valueOf((int)(1000+Math.random() *8999) );
        //将验证码存入session
        HttpSession session = req.getSession();
        session.setAttribute("check",num);
        graphics.drawString(num,30,30);
        //画干扰线
        graphics.setColor(Color.GREEN);
        Random r = new Random();
        for (int i = 0; i <10 ; i++) {
            int x1 = r.nextInt(w);
            int x2 = r.nextInt(w);
            int y1 = r.nextInt(h);
            int y2 = r.nextInt(h);
            graphics.drawLine(x1,y1,x2,y2);
        }
        //输出
        ImageIO.write(bf,"jpg",resp.getOutputStream());

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
