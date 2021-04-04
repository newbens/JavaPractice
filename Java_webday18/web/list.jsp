<%--
  Created by IntelliJ IDEA.
  User: lenovo-pc
  Date: 2020/4/28
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>


    <script>
        function deleteStaff(id) {
            //用户提示
            if(confirm("宁确定删除吗？"))
            location.href = "${pageContext.request.contextPath}/delStaffServlet?id=" + id;
        };
    </script>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">用户信息列表</h3>
    <div style="float: left">
        <form class="form-inline" method="post" action="${pageContext.request.contextPath}/findStaffByPageServlet">
            <div class="form-group">
                <label for="exampleInputName2">姓名</label>
                <input type="text" name="name" value="${pm.name[0]}" class="form-control" id="exampleInputName2">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail2">籍贯</label>
                <input type="text" name="address" value="${pm.address[0]}" class="form-control" id="exampleInputEmail2">
            </div>
            <div class="form-group">
                <label for="exampleInputName3">邮箱</label>
                <input type="email" name="email" value="${pm.email[0]}" class="form-control" id="exampleInputName3">
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>
    </div>
    <div style="float: right;margin: 10px" >
        <tr>
            <td colspan="8" align="center"><a class="btn btn-primary" href="add.jsp">添加联系人</a></td>
        </tr>
<%--        <tr>--%>
<%--            <td colspan="8" align="center"><a class="btn btn-primary" href="javascript:delSelected() ;" id="delSelect">删除选中</a></td>--%>
<%--        </tr>--%>

    </div>
    <form id="form" action="${pageContext.request.contextPath}/delSelectServlet" method="post">
    <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th><input type="checkbox" id="firstCheckBox"></th>
            <th>编号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>籍贯</th>
            <th>QQ</th>
            <th>邮箱</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${pb.list}"  var="staff">
            <tr>
                <th><input type="checkbox" name="uid" value="${staff.id}"></th>
                <td>${staff.id}</td>
                <td>${staff.name}</td>
                <td>${staff.gender}</td>
                <td>${staff.age}</td>
                <td>${staff.address}</td>
                <td>${staff.phone}</td>
                <td>${staff.email}</td>
                <td><a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/findStaffServlet?id=${staff.id}">修改</a>&nbsp;
                    <a class="btn btn-default btn-sm" href="javascript:deleteStaff(${staff.id})">删除</a></td>
            </tr>
        </c:forEach>
    </table>
    </form>
        <div>
        <nav aria-label="...">
            <ul class="pagination">
                <c:if test="${pb.currentPage == 1}">
                    <li class="disabled"><a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
                </c:if>
                <c:if test="${pb.currentPage != 1}">
                    <li><a href="${pageContext.request.contextPath}/findStaffByPageServlet?currentPage=${pb.currentPage-1}&rows=3&name=${pm.name[0]}&address=${pm.address[0]}&email=${pm.email[0]}" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
                </c:if>
                <c:forEach begin="1" end="${pb.pageSum}" var="i">
                    <c:if test="${pb.currentPage == i}">
                        <li class="active"><a href="${pageContext.request.contextPath}/findStaffByPageServlet?currentPage=${i}&rows=3&name=${pm.name[0]}&address=${pm.address[0]}&email=${pm.email[0]}">${i} <span class="sr-only">(current)</span></a></li>
                    </c:if>
                    <c:if test="${pb.currentPage != i}">
                        <li><a href="${pageContext.request.contextPath}/findStaffByPageServlet?currentPage=${i}&rows=3&name=${pm.name[0]}&address=${pm.address[0]}&email=${pm.email[0]}">${i} <span class="sr-only">(current)</span></a></li>
                    </c:if>
                </c:forEach>
                <c:if test="${pb.currentPage == pb.pageSum}">
                    <li class="disabled">
                        <a href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:if>
                <c:if test="${pb.currentPage != pb.pageSum}">
                    <li>
                        <a href="${pageContext.request.contextPath}/findStaffByPageServlet?currentPage=${pb.currentPage+1}&rows=3&name=${pm.name[0]}&address=${pm.address[0]}&email=${pm.email[0]}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:if>
                <span style="font-size: 25px">共${pb.infoSum}条数据，共${pb.pageSum}页</span>

                ...
            </ul>
        </nav>
    </div>
</div>


</body>
<script>
    //绑定事件
    function delSelected() {
        document.getElementById("delSelect").onclick = function () {
            //先判断是否为空
            var uids = document.getElementsByName("uid");
            var flag = false;
            for (var i = 0; i <uids.length ; i++) {
                console.log(uids[i].checked);
                if (uids[i].checked) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                if(confirm("宁确定要删除吗？")){
                    document.getElementById("form").submit();
                }
            }else {
                alert("未选中任何数据！")
            }
        }
    }
    //批量选择
    document.getElementById("firstCheckBox").onclick = function () {
        // 获取一共多少个uid
        var uids = document.getElementsByName("uid");
        for (var i = 0; i < uids.length ; i++) {
            //设置每一个CheckBox的状态
            uids[i].checked = this.checked;
        }
    }
</script>
</html>
