<%--
  Created by IntelliJ IDEA.
  User: 杨
  Date: 2021/11/7
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>增加用户信息</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/adduserservlet" method="post">
        <table align="center">
            <tr>
                <td>ID号：</td>
                <td><input type="text" name="id"/><span>${requestScope.erroid}</span></td>
            </tr>
            <tr>
                <td>姓名:</td>
                <td><input type="text" name="name"/></td>
            </tr>
            <tr>
                <td>年龄:</td>
                <td><input type="text" name="age"/></td>
            </tr>
            <tr>
                <td>email:</td>
                <td><input type="email" name="email"/></td>
            </tr>
            <tr>
                <td>性别：</td>
                <td><input type="radio"  name="sex" value="男" checked="checked">男
                    <input type="radio"  name="sex" value="女">女
                </td>
            </tr>
            <tr>
                <td><input type="submit" value="确定"/></td>
                <td><input type="reset" value="重置"/></td>
            </tr>
        </table>
    </form>
</body>
</html>
