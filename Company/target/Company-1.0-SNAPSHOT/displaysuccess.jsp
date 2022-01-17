
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<jsp:useBean id="user" class="com.company.crdu.model.User" scope="session"></jsp:useBean>
<html>
<head>
    <title>Title</title>
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
<h3>查询到的用户信息如下：</h3>
<table border="1" class="table table-hover table-condensed table-bordered">
    <tr>
        <th>ID号</th><th>姓名</th><th>年龄</th><th>性别</th><th>email</th>
    </tr>
    <tr>
        <td><jsp:getProperty name="user" property="id"/></td>
        <td><jsp:getProperty name="user" property="name"/></td>
        <td><jsp:getProperty name="user" property="age"/></td>
        <td><jsp:getProperty name="user" property="sex"/></td>
        <td><jsp:getProperty name="user" property="email"/></td>
    </tr>
</table>

<a href="ManageUser.jsp">点击回到首页</a>
</body>
</html>
