<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: lenovo-pc
  Date: 2020/4/27
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--
        test是必须的，类型是Boolean类型。如果是true显示标签体内容，否则不
    --%>
    <c:if test="true">我是真心的！</c:if>
    <c:if test="false">我是真心的！</c:if>
    <%
        List list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        request.setAttribute("list", list);
    %>
    <c:if test="${not empty list}">
        遍历
    </c:if>

    <%--
        choose == switch  when == case    otherwise==default
    --%>
    <%
        request.setAttribute("num",1);
    %>
    <c:choose>
        <c:when test="${num == 1}">星期一</c:when>
        <c:when test="${num == 2}">星期二</c:when>
        <c:when test="${num == 3}">星期三</c:when>
        <c:when test="${num == 4}">星期四</c:when>
        <c:when test="${num == 5}">星期五</c:when>
        <c:when test="${num == 6}">星期六</c:when>
        <c:when test="${num == 7}">星期七</c:when>

    </c:choose>
    <%--              foreach           --%>
    <c:forEach begin="1" end="10" var="i" step="1">
        ${i}<br>
    </c:forEach>

    <c:forEach items="${list}" var="str" varStatus="s">
        ${s.index} <!-- 循环下标-->
        ${s.count} <!-- 循环次数-->
        ${str}
    </c:forEach>
</body>
</html>
