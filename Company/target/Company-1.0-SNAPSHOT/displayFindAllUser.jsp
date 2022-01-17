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
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>显示所有信息</title>
    <style type="text/css">
        .page{text-align: center;margin-top: 50px;}
        .page a{text-decoration: none;border:1px solid #f9d52b;padding: 5px 7px;color: #767675;cursor: pointer;}
        .page a:hover,.page span:hover{
            color: red;
        }
    </style>
</head>
<body>
<h2 align="center">用户所有信息如下</h2>
<table align="center" class="table-hover table table-bordered">
    <tr>

        <th>序号</th>
        <th>ID号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>性别</th>
        <th>Email</th>
        <th colspan="2">操作</th>
    </tr>
    <c:forEach items="${pb.list}" var="user" varStatus="status">
        <tr>
            <td align="center">${status.count}</td>
            <td align="center">${user.id}</td>
            <td align="center">${user.name}</td>
            <td align="center">${user.age}</td>
            <td align="center">${user.sex}</td>
            <td align="center">${user.email}</td>
            <td><a href="${pageContext.request.contextPath}/deleteuserservlet?id=${user.id}">删除</a></td>
            <td><a href="${pageContext.request.contextPath}/updatebyidservlet?id=${user.id}">更改</a></td>
        </tr>
    </c:forEach>
</table>
<div align="center" class="page">
    <a href="${pageContext.request.contextPath}/finduserinpageservlet?currentPage=1&rows=5"><span>首页</span></a>
   <a href="${pageContext.request.contextPath}/finduserinpageservlet?currentPage=${pb.currentPage-1}&rows=5"><span>上一页</span></a>
    <c:forEach begin="1" end="${pb.totalPage}" var="i">
        <a href="${pageContext.request.contextPath}/finduserinpageservlet?currentPage=${i}&rows=5">${i}</a>
    </c:forEach>
    <c:if test="${pb.currentPage!=pb.totalPage}">
        <a href="${pageContext.request.contextPath}/finduserinpageservlet?currentPage=${pb.currentPage+1}&rows=5"><span>下一页</span></a>
    </c:if>
    <a href="${pageContext.request.contextPath}/finduserinpageservlet?currentPage=${pb.totalPage}&rows=5"><span>尾页</span></a>
    <span>共${pb.totalCount}条记录，共${pb.totalPage}页</span>
</div>
<hr>
<div align="center"><a href="ManageUser.jsp">点击此处回到首页</a></div>
</body>
</html>
