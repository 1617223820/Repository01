<%--
  Created by IntelliJ IDEA.
  User: 杨
  Date: 2021/11/21
  Time: 19:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/userUpdateServlet" method="post">
    <table align="center">
        <tr>
            <td>请输入要更改信息的ID号：</td>
            <td><input type="text" name="id" value="${realUser.id}"/></td><span>${requestScope.error}</span>
        </tr>
        <tr>
            <td align="right">姓名:</td>
            <td><input type="text" name="name" value="${realUser.name}"/></td>
        </tr>
        <tr>
            <td align="right">年龄:</td>
            <td><input type="text" name="age" value="${realUser.age}"/></td>
        </tr>
        <tr>
            <td align="right">email:</td>
            <td><input type="email" name="email" value="${realUser.email}"/></td>
        </tr>
        <tr>
            <td align="right">性别：</td>
            <c:if test="${realUser.sex=='男'}">
                <td><input type="radio"  name="sex" value="男" checked="checked">男
                    <input type="radio"  name="sex" value="女">女
                </td>
            </c:if>
            <c:if test="${realUser.sex=='女'}">
                <td><input type="radio"  name="sex" value="男" >男
                    <input type="radio"  name="sex" value="女" checked="checked">女
                </td>
            </c:if>
            <c:if test="${realUser.sex==null}">
                <td><input type="radio"  name="sex" value="男" checked="checked">男
                    <input type="radio"  name="sex" value="女">女
                </td>
            </c:if>
        </tr>
        <tr>
            <td align="right">用户名</td>
            <td><input type="text" name="username" value="${sessionScope.realUser.username}"/></td>
        </tr>
        <tr>
            <td align="right">密码:</td>
            <td><input type="password" name="password" value="${sessionScope.realUser.password}"/></td>
        </tr>
        <tr>
            <td align="right"><input type="submit" value="确定"/></td>
            <td align="right"><input type="reset" value="重置"/></td>
        </tr>
    </table><span>${requestScope.success}</span>
</form>
</body>
</html>
