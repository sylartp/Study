<%--
  Created by IntelliJ IDEA.
  User: tppppp
  Date: 2016/12/1
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ page isELIgnored="false" %>--%>
<html>
<head>
    <title>Show</title>
</head>
<body>
    <c:out value="${user.userName}"/><br/>
    <c:out value="${user.passWord}"/>
</body>
</html>
