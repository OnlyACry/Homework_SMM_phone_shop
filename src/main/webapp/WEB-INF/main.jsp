<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<base href="${pageContext.request.contextPath}/"/>
<head>
    <meta charset="UTF-8">
    <title>主界面</title>
    <link rel="stylesheet" href="static/css/bootstrap.css" />
</head>
<body>
<p class="text-center">${user.userName}欢迎</p>
<table class="table table-condensed table-bordered">
    <tr>
        <th>编号</th><th>名称</th><th>功能链接</th><th>父级编号</th><th>链接目标</th><th>操作</th>
    </tr>
    <c:forEach var="fun" items="${list}">
        <tr>
            <td>${fun.funId}</td>
            <td>${fun.funName}</td>
            <td>${fun.funUrl}</td>
            <td>${fun.funPid}</td>
            <td>${fun.funTarget}</td>
            <td><a href="#">删除</a><a href="#">编辑</a> </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

