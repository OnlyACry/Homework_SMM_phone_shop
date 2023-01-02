<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<base href="${pageContext.request.contextPath}/"/>
<head>
    <meta charset="utf-8" />
    <title>编辑页</title>
    <link rel="stylesheet" href="static/css/bootstrap.css" />
</head>
<body>
<div class="container">
    <div class="col-md-4 col-lg-offset-4">
        <form action="fun/update" method="post">
            <!--更新需要id-->
            <input type="hidden" name="funId" value="${fun.funId}"/>
            <table class="table table-bordered table-condensed">
                <tr>
                    <td>名称:</td>
                    <td><input type="text"  name="funName" value="${fun.funName}"  /> </td>
                </tr>
                <tr>
                    <td>URL:</td>
                    <td><input type="text" name="funUrl" value="${fun.funUrl}" /> </td>
                </tr>
                <tr>
                    <td>父级ID:</td>
                    <td>
                        <select name="funPid">
                            <option value="">请选择</option>
                            <c:forEach var="f" items="${list}">
                                <option value="${f.funId}"
                                        <c:if test="${f.funId == fun.funPid}">
                                            selected
                                        </c:if>
                                >${f.funName}</option>
                            </c:forEach>
                        </select>

                    </td>
                </tr>
                <tr>
                    <td>TARGET:</td>
                    <td><input type="text"  name="funTarget" value="${fun.funTarget}"/> </td>
                </tr>
                <tr>
                    <td>SORT:</td>
                    <td><input type="text"  name="funSort" value="${fun.funSort}"/> </td>
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