<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="cn.domain.User" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: lenovo-pc
  Date: 2020/4/27
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <%
            List<User> list = new ArrayList<>();
            list.add(new User("牛犇","1998","0115"));
            list.add(new User("牛奔","1988","0115"));
            list.add(new User("牛本","1978","0115"));
            request.setAttribute("list",list);
        %>

        <table border="1" width="500" align="center">
            <tr>
                <th>姓名</th>
                <th>出生年</th>
                <th>月日</th>
            </tr>
            <c:forEach items="${list}" var="user" varStatus="s">
                <tr>
                    <td>${user.username}</td>
                    <td>${user.password}</td>
                    <td>${user.check}</td>
                </tr>
            </c:forEach>
        </table>

</body>
</html>
