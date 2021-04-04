<%--
  Created by IntelliJ IDEA.
  User: lenovo-pc
  Date: 2020/5/9
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <h1>入门程序</h1>
    <a href="hello">点击跳转</a>

    <form action="/param/saveAccount" method="post">
        将数据分装在account不包含集合
        账户“:<input type="text" name="username" placeholder="请输入账户"><br>
        密码:<input type="text" name="password" placeholder="请输入密码"><br>
        金额:<input type="text" name="money" placeholder="请输入金额"><br>
        用户姓名:<input type="text" name="user.uname" placeholder="请输入用户姓名">
        用户年龄:<input type="text" name="user.age" placeholder="请输入用户年龄">
        <input type="submit" value="提交">
    </form>
    <hr>

    <form action="/param/saveAccount" method="post">
        将数据分装在account包含集合<br>
        账户“:<input type="text" name="username" placeholder="请输入账户"><br>
        密码:<input type="text" name="password" placeholder="请输入密码"><br>
        金额:<input type="text" name="money" placeholder="请输入金额"><br>
        用户姓名:<input type="text" name="user.uname" placeholder="请输入用户姓名"><br>
        用户年龄:<input type="text" name="user.age" placeholder="请输入用户年龄"><br>

        用户姓名:<input type="text" name="lists[0].uname" placeholder="请输入用户姓名"><br>
        用户年龄:<input type="text" name="lists[0].age" placeholder="请输入用户年龄"><br>

        用户姓名:<input type="text" name="maps['user1'].uname" placeholder="请输入用户姓名"><br>
        用户年龄:<input type="text" name="maps['user1'].age" placeholder="请输入用户年龄"><br>
        <input type="submit" value="提交">
    </form>
<hr>

    <form action="/param/saveUser" method="post">
    用户姓名<input type="text" name="uname"><br>
    用户年龄<input type="text" name="age"><br>
    出生年月<input type="text" name="date"><br>
        <input type="submit" value="提交">
    </form>
<hr>

    <a href="param/testRequestParam?surname=tom">Servlet原生API</a>

</body>

<hr>
<h1>RequestBody注解</h1>
<form action="/param/testRequestBody" method="post">
    用户姓名<input type="text" name="uname"><br>
    用户年龄<input type="text" name="age"><br>
    出生年月<input type="text" name="date"><br>
    <input type="submit" value="提交">
</form>
<hr>
<h1>PathVariable</h1>
<a href="/param/testPathVariable/10">PathVariable</a>
<hr>
<h1>ModelAttribute</h1>
<form action="/param/testModelAttribute" method="post">
    用户姓名<input type="text" name="uname"><br>
    用户年龄<input type="text" name="age"><br>
    出生年月<input type="text" name="date"><br>
    <input type="submit" value="提交">
</form>

<hr>
<h1>
    sessionAttribute
</h1>
    <a href="/param/setsessionAtttributes">sessionAttribute</a>
    <a href="/param/getsessionAtttributes">sessionAttribute</a>
    <a href="/param/delsessionAtttributes">sessionAttribute</a>

</html>
