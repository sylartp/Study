<%--
  Created by IntelliJ IDEA.
  User: tppppp
  Date: 2016/12/1
  Time: 01:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form method="post">
        用户名:<input type="text" name="userName"/><br/>
        密码:<input type="password" name="passWord"/><br/>
        <input type="submit" value="登陆"/>
    </form>
</body>
</html>
