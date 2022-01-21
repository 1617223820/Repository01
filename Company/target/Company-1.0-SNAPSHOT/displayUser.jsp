<%--
  Created by IntelliJ IDEA.
  User: 杨
  Date: 2021/11/7
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>显示</title>
</head>
<body>
<form action="./displayuserservlet" method="post">
    <table>
        <tr>
            <td>请输入要查询用户信息的ID号：</td>
            <td><input type="text" name="id"></td>
            <td>
                <input type="submit" name="submit" value="提交">
                <input type="reset" name="reset" value="重置"><span>${requestScope.error}</span>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
