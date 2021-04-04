<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
    <head>
        <!-- 指定字符集 -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>修改用户</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script src="js/jquery-2.1.0.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        
    </head>
    <body>
        <div class="container" style="width: 400px;">
        <h3 style="text-align: center;">修改</h3>
        <form action="${pageContext.request.contextPath}/updateTeacherServlet" method="post">
            <!--  隐藏域 提交id-->
            <input type="hidden" name="id" value="${teacher.id}">
          <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name"  value="${teacher.name}" readonly="readonly" placeholder="请输入姓名" />
          </div>
          <div class="form-group">
            <label>性别：</label>
              <c:if test="${teacher.gender == '男'}">
                  <input type="radio" name="gender" value="男" checked />男
                  <input type="radio" name="gender" value="女"  />女
              </c:if>

          </div>
          <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" value="${teacher.age}" id="age"  name="age" placeholder="请输入年龄" />
          </div>
          <div class="form-group">
            <label for="email">Email：</label>
            <input type="text" id="email" class="form-control" value="${teacher.email}" name="email" placeholder="请输入邮箱地址"/>
          </div>
            <div class="form-group">
                <label for="email">住址：</label>
                <input type="text" id="address" class="form-control" value="${teacher.address}" name="address" placeholder="请输入住址"/>
            </div>
            <div class="form-group">
                <label for="email">所属学院：</label>
                <input type="text" id="college" class="form-control" value="${teacher.college}" name="college" placeholder="请输入所属学院"/>
            </div>
             <div class="form-group" style="text-align: center">
                <input class="btn btn-primary" type="submit" value="提交" />
             </div>
        </form>
        </div>
    </body>
</html>