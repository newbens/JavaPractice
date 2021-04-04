<%--
  Created by IntelliJ IDEA.
  User: lenovo-pc
  Date: 2020/5/16
  Time: 21:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <form action="/web/TestServlet4" method="post">
        账户<input name="username" type="text" placeholder="请输入用户名"><br>
        密码<input name="password" type="password" placeholder="请输入密码"><br>
        <input type="submit" value="提交">
        <span><%= request.getAttribute("error")==null ? "":request.getAttribute("error")%></span>
    </form>
</body>
</html>
