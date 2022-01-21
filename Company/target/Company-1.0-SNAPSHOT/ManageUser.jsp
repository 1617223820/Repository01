<%--
  Created by IntelliJ IDEA.
  User: 杨
  Date: 2021/11/7
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>用户信息管理系统</title>
</head>
<body>
<h2 align="center">欢迎管理员${sessionScope.real_login.username}使用用户信息管理系统</h2>
<table align="center" border="1" width="250">
    <tr><td align="center">请选择要执行的操作:</td></tr>
    <tr><td align="center"><a href="addUser.jsp">增加用户信息</a></td></tr>
    <tr><td align="center"><a href="deleteUser.jsp">删除用户信息</a></td></tr>
    <tr><td align="center"><a href="updateUser.jsp">修改用户信息</a></td></tr>
    <tr><td align="center"><a href="displayUser.jsp">查询单个用户信息</a></td></tr>
    <tr><td align="center"><a href="${pageContext.request.contextPath}/finduserinpageservlet">查询所有用户信息</a></td></tr>
</table>
</body>
</html>
