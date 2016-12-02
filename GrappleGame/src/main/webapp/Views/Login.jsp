<%--
  Created by IntelliJ IDEA.
  User: tppppp
  Date: 2016/12/1
  Time: 01:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Login</title>
    <style type="text/css">
        span.errors {
            color: red;
        }
    </style>
</head>
<body>
<p1><s:message code="user.welcome"/></p1>
<sf:form method="post" commandName="user">
    用户名:<sf:input path="userName"/>
    <sf:errors path="userName" cssClass="errors"/> <br/>
    密码:<sf:input path="passWord"/>
    <sf:errors path="passWord" cssClass="errors"/> <br/>
    <input type="submit" value="登陆"/>
</sf:form>
</body>
</html>
