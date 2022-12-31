<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
        <form action="user/login" method="post">
            <table class="table table-bordered table-condensed">
                <tr>
                    <td>账号:</td>
                    <td><input type="text" name="name" /> </td>
                </tr>
                <tr>
                    <td>密码:</td>
                    <td><input type="password" name="pwd"/> </td>
                </tr>
                <tr>
                    <td colspan="2" class="text-center">
                        <input type="submit" value="登陆" />
                        <input type="reset" value="重置" />
                        <span class="text-warning">${error}</span>
                    </td>

                </tr>
            </table>
        </form>

    </div>
</div>
</body>
</html>
