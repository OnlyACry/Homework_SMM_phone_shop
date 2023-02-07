<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<base href="${pageContext.request.contextPath}/"/>
<head>
    <meta charset="utf-8" />
    <title>登陆</title>
    <link rel="stylesheet" href="static/css/bootstrap.css" />
</head>
<body>
<div class="container">
    <div class="col-md-4 col-lg-offset-4">
        <form action="fun/save" method="post">
            <table class="table table-bordered table-condensed">
                <tr>
                    <td>名称:</td>
                    <td><input type="text"  name="funName"  /> </td>
                </tr>
                <tr>
                    <td>URL:</td>
                    <td><input type="text" name="funUrl"  /> </td>
                </tr>
                <tr>
                    <td>父级ID:</td>
                    <td>
                        <select name="funPid">
                            <option>请选择</option>
                            <c:forEach var="fun" items="${list}">
                                <option value="${fun.funId}">${fun.funName}</option>
                            </c:forEach>
                        </select>

                    </td>
                </tr>
                <tr>
                    <td>TARGET:</td>
                    <td><input type="text"  name="funTarget" /> </td>
                </tr>
                <tr>
                    <td>SORT:</td>
                    <td><input type="text"  name="funSort" /> </td>
                </tr>

                <tr>
                    <td colspan="2" class="text-center">
                        <input type="submit" value="保存" />
                        <input type="reset" value="重置" />
                    </td>

                </tr>
            </table>
        </form>

    </div>
</div>
</body>
</html>
