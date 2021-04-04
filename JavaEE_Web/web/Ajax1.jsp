<%--
  Created by IntelliJ IDEA.
  User: lenovo-pc
  Date: 2020/5/1
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ajax</title>
    <script src="js/jquery-2.1.0.min.js"></script>
    <script>
        function fun() {
            //使用$.ajax()发送异步请求
            $.ajax({
                url: "ajaxServlet",
                type: "POST",
                // data:"name=niuben"
                data: {"name": "niuben", "age": "22"},  //json格式
                success: function (data) {
                    alert(data);
                },//响应成功的回调函数
            })

        }
    </script>
</head>
<body>
<input type="button" value="发送异步请求" onclick="fun()">
<input type="text">
</body>
</html>
