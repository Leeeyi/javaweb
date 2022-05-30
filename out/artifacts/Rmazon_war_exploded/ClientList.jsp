<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 17567
  Date: 2022/5/17
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Bean.User" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="right">
    <a href="${pageContext.request.contextPath}/BigData.jsp">主页</a>
</div>
<font size="5"> <div align="center">选择要查看的用户</div></font><br>
<c:forEach items="${client}" var="User">
    <div align="center"><a href="${pageContext.request.contextPath}/userpersona?id=${User.getId()}&&name=${User.getName()}">${User.getName()}</a></div><br>
</c:forEach>
</body>
</html>
