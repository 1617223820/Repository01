<%--
  Created by IntelliJ IDEA.
  User: 杨
  Date: 2021/11/7
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>更新</title>
</head>
<body>
<form action="./updateuserservlet" method="post">
    <table align="center">
        <tr>
            <td>请输入要更改信息的ID号：</td>
            <td><input type="text" name="id" value="${user.id}"/></td><span>${requestScope.erroid}</span>
        </tr>
        <tr>
            <td align="right">姓名:</td>
            <td><input type="text" name="name" value="${user.name}"/></td>
        </tr>
        <tr>
            <td align="right">年龄:</td>
            <td><input type="text" name="age" value="${user.age}"/></td>
        </tr>
        <tr>
            <td align="right">email:</td>
            <td><input type="email" name="email" value="${user.email}"/></td>
        </tr>
        <tr>
            <td align="right">性别：</td>
            <c:if test="${user.sex=='男'}">
                <td><input type="radio"  name="sex" value="男" checked="checked">男
                    <input type="radio"  name="sex" value="女">女
                </td>
            </c:if>
            <c:if test="${user.sex=='女'}">
                <td><input type="radio"  name="sex" value="男" >男
                    <input type="radio"  name="sex" value="女" checked="checked">女
                </td>
            </c:if>
            <c:if test="${user.sex==null}">
                <td><input type="radio"  name="sex" value="男" checked="checked">男
                    <input type="radio"  name="sex" value="女">女
                </td>
            </c:if>
        </tr>
        <tr>
            <td align="right"><input type="submit" value="确定"/></td>
            <td align="right"><input type="reset" value="重置"/></td>
        </tr>
    </table>
</form>
</body>
</html>
