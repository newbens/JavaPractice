<%--
  Created by IntelliJ IDEA.
  User: lenovo-pc
  Date: 2020/5/16
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:useBean id="count" class="cn.Bean.CounterBean" scope="application"></jsp:useBean>
<head>
    <title>Title</title>
</head>
<body>
    <%
        if (session.isNew()) {
            Integer count1 = count.getCount();
            count1 += 1;
            count.setCount(count1);
        }
    %>
    <h1>访问数:</h1>
    <jsp:getProperty name="count" property="count"></jsp:getProperty>
</body>
</html>
