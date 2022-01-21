<%--
  Created by IntelliJ IDEA.
  User: 杨
  Date: 2021/11/18
  Time: 18:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>管理员登录页面</title>
    <script type="text/javascript">
        //刷新验证码
        function changeImg(obj,createTypeFlag){
            document.getElementById(obj.id).src="CheckServlet?createTypeFlag="+createTypeFlag+"&"+Math.random();
        }
    </script>
</head>
<body>
<h2 align="center">企业信息系统</h2>
<form  method="post" action="${pageContext.request.contextPath}/loginServlet">
    <table border="1" align="center">
        <tr>
            <td>用户名：</td>
            <td colspan="2"><input type="text" name="username" id="username"></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td colspan="2"><input type="password" name="password" id="password"></td>
        </tr>
        <tr>
            <td>验证码：</td>
            <td><input type="text" name="check" id="check"></td>
            <td><img src="${pageContext.request.contextPath}/CheckServlet" id="validateCodeImg1" onclick="changeImg(this,'nl')">
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="确定"></td>
            <td><input type="reset" value="重置" ></td>
        </tr>
    </table>
</form>
<div align="center"><span>${requestScope.checkerror}${requestScope.error}</span></div><br>
<div align="center"><span>${requestScope.loginerror}</span></div>
</body>
</html>
