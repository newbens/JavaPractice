<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: lenovo-pc
  Date: 2020/4/24
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.text.SimpleDateFormat" %>
<html>
<head>
    <title>show</title>
</head>
    <style>
        div{
            margin-left: 450px;
            margin-top: 200px;
            width: 300px;
            text-align: center;
            background: turquoise;
        }
    </style>
<body>
    <div>
    <%
        /*
        7-11点输出早上好
        11-14点输出中午好
        14-18点输出下午好
        18-24 && 0-7 输出点晚上好
        */
        Date date = new Date();
        String s = new SimpleDateFormat("HH:mm:ss").format(date);
        int time = Integer.parseInt(s.substring(0, 2));
        if (14< time && time <= 18 ) {
            out.print("下午好");
        } else if (7 < time && time <= 11) {
            out.print("上午好");
        } else if (11 < time && time <= 14) {
            out.print("中午好");
        }else {
            out.print("晚上好");
        }
        out.print("<br>");
        out.print("当前时间:"+s);
    %>
    </div>

</body>
</html>
