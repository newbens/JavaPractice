<%--
  Created by IntelliJ IDEA.
  User: lenovo-pc
  Date: 2020/4/27
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>从域中获取值</title>
</head>
<body>
    <%
        request.setAttribute("res","res");
        session.setAttribute("ses","session");
    %>
    <h1>获取值</h1>
    ${requestScope.get("res")}
    ${sessionScope.get("ses")}
</body>
</html>
