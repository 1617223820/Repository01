<%--
  Created by IntelliJ IDEA.
  User: 杨
  Date: 2021/11/21
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>用户菜单</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <!-- Bootstrap -->
    <link rel="stylesheet" href="css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js" integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ" crossorigin="anonymous"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
</head>
<body>
<h2 align="center">欢迎用户${sessionScope.realUser.username}登录用户信息管理系统</h2>
<table border="1" class="table table-hover table-condensed table-bordered">
    <tr>
        <th>ID号</th><th>姓名</th><th>年龄</th><th>性别</th><th>email</th><th>用户名</th><th>密码</th>
    </tr>
    <tr>
        <td>${sessionScope.realUser.id}</td>
        <td>${sessionScope.realUser.name}</td>
        <td>${sessionScope.realUser.age}</td>
        <td>${sessionScope.realUser.sex}</td>
        <td>${sessionScope.realUser.email}</td>
        <td>${sessionScope.realUser.username}</td>
        <td>${sessionScope.realUser.password}</td>
    </tr>
    <div align="right"><a href="User/UpdateUser.jsp">修改信息</a></div>
</table>
</body>
</html>
