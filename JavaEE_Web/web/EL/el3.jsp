<%@ page import="cn.domain.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: lenovo-pc
  Date: 2020/4/27
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el3</title>
</head>
<body>
    <%
        request.setCharacterEncoding("utf-8");
        User user = new User("123", "123456", "1998");
        request.setAttribute("user",user);
    %>
    ${requestScope.user.username}<br>
    ${requestScope.user.password}<br>
    <%
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        request.setAttribute("list",list);
    %>
    ${requestScope.list[0]}<br>
    <%
        Map<String, String> map = new HashMap<>();
        map.put("牛犇", "男");
        request.setAttribute("map",map);
    %>
    ${map.牛犇}<br>
    ${map["牛犇"]}<br>

</body>
</html>
