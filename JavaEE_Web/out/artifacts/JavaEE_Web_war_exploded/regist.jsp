<%--
  Created by IntelliJ IDEA.
  User: lenovo-pc
  Date: 2020/5/1
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="js/jquery-3.3.1.js"></script>
<html>
<head>
    <title>注册</title>
</head>
<body>
    <form>
        <input type="text" id="name" placeholder="请输入用户名" name="username"><span id="span_username"></span><br>
        <input type="password" placeholder="请输入用户名" name="password1"><br>
        <input type="password" placeholder="确认密码" name="password2"><br>
        <input type="submit" value="提交">
    </form>
</body>
<script>
        $("#name").blur(function () {
            //获取username值
            var username = $(this).val();
            //发送ajax请求
            $.get("findUserServlet", {"username": username}, function (data) {
                //将String类型转为Json
                data = JSON.parse(data);
                var span = $("#span_username");
                if (!data.exsit) {
                    //表示用户名存在
                    span.css("color", "red");
                    span.html(data.msg);
                } else {
                    span.css("color", "green");
                    span.html(data.msg);
                }

            });
        })

</script>

</html>
