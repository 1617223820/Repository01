<%--
  Created by IntelliJ IDEA.
  User: 杨
  Date: 2021/11/22
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
<h2 align="center">请填写此表单完成注册</h2>
<form method="post" action="${pageContext.request.contextPath}/registerServlet">
    <table align="center">
        <tr>
            <td>请输入要注册账号的ID号：</td>
            <td><input type="text" name="id"></td>${requestScope.error}
        </tr>
        <tr>
            <td align="right">用户名：</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td align="right">密码：</td>
            <td><input type="password" name="password" id="password"></td>
        </tr>
        <tr>
            <td align="center"><input type="submit" value="提交"></td>
            <td align="center"><input type="reset" value="重置"></td>
        </tr>
    </table>
</form>
</body>
</html>
