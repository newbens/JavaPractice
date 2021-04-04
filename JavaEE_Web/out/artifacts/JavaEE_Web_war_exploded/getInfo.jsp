<%--
  Created by IntelliJ IDEA.
  User: lenovo-pc
  Date: 2020/5/12
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取客户端浏览器类型和IP</title>
</head>
<body>
    <%
        if (session.getAttribute("visit") == null) {
            session.setAttribute("visit","true");
            if (application.getAttribute("sum") == null) {
                application.setAttribute("sum",1);
            }else {
                int sum = (int) application.getAttribute("sum");
                out.print(sum);
                sum ++;
                application.setAttribute("sum", sum);
            }
        }
    %>

</body>
</html>
