<%--
  Created by IntelliJ IDEA.
  User: lenovo-pc
  Date: 2020/5/11
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
    <a href="/springmvc/testString">testString</a>
<hr>
    <a href="/springmvc/testVoid">testVoid</a>

    <hr>
    <a href="/springmvc/testModelAndView">testModelAndView</a>

    <hr>
    <a href="/springmvc/testForwardOrRedirect">testForWardOrRedirect</a

        <hr>
<h1>传统方式文件上传</h1>
    <form action="/file/upload1" method="post" enctype="multipart/form-data">
        选择文件”:<input type="file" name="upload"/><br>
        <input type="submit" value="上传"/>
    </form>
</body>

<h1>springmvc方式文件上传</h1>
<form action="/file/upload2" method="post" enctype="multipart/form-data">
    选择文件”:<input type="file" name="upload"/><br>
    <input type="submit" value="上传"/>
</form>


<h1>跨服务器文件上传文件上传</h1>
<form action="/file/upload3" method="post" enctype="multipart/form-data">
    选择文件”:<input type="file" name="upload"/><br>
    <input type="submit" value="上传"/>
</form>
</body>
</html>
