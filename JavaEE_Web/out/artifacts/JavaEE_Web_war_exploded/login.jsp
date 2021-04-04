<%--
  Created by IntelliJ IDEA.
  User: lenovo-pc
  Date: 2020/4/27
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script>
    window.onload = function () { //页面加载后运行
        var p = document.getElementById("img");
        var i = 1;
        p.onclick = function () {   //给超链接绑定点击事件
            p.src = "/web/checkcode?"+i+++"";
        }
        var c = document.getElementById("imag");
        c.onclick = function () {   //给图片绑定点击事件

            c.src = "/web/checkcode?"+i+++"";
        }
    }
</script>
<body>
<form action="/web/LoginServlet" method="get">
    <input name="username" placeholder="请输入账户">
    <%= request.getAttribute("l") == null ? "":request.getAttribute("l")%><br>
    <input name="password" placeholder="请输入密码"><br>
    <input name="check" placeholder="请输入验证码"><br>
    <img src="/web/checkcode" id="imag">
    <%= request.getAttribute("c") == null ? "": request.getAttribute("c")%>
    <a href="/web/login.jsp" id="img">看不清换一张？</a><br>
    <input type="submit" value="登陆" >
</form>

</body>
</html>
