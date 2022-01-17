<%--
  Created by IntelliJ IDEA.
  User: 杨
  Date: 2021/11/21
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>企业信息系统</title>
</head>
<body>
<h2 align="center">企业信息系统</h2>
<div align="center"><a href="adminLogin.jsp">管理员入口</a></div>
<div align="center"><a href="User/userLogin.jsp">用户入口</a></div><br>
<div align="center"><span>${requestScope.loginerror}</span></div>
</body>
</html>
