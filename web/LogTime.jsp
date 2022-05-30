<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<style type="text/css">
    /*这里是一些css代码，用来美化表格的，不重要*/
    table {
        width: 90%;
        background: #ccc;
        margin: 10px auto;
        border-collapse: collapse;
    }
    th,td {
        height: 25px;
        width: 50px;
        line-height: 25px;
        text-align: center;
        border: 1px solid #ccc;
    }
    th {
        background: #eee;
        font-weight: normal;
    }
    tr {
        background: #fff;
    }
    td a {
        color: #06f;
        text-decoration: none;
    }
    td a:hover {
        color: #06f;
        text-decoration: underline;
    }
    div{float:right}
</style>
<body>
<div align="right">
    <a href="${pageContext.request.contextPath}/BigData.jsp">主页</a>
</div>
<h2 align="center">如下为全部用户的登录时间及ip的统计</h2>
<table>
    <thead>
    <tr>
        <th>用户id</th>
        <th>用户名</th>
        <th>登陆时间</th>
        <th>登出时间</th>
        <th>登录ip</th>
    </tr>
    </thead>
    <c:forEach items="${logtime}" var="UserBig">
        <tr>
            <td>${UserBig.getId()}</td>
            <td>${UserBig.getName()}</td>
            <td>${UserBig.getLoginTime()}</td>
            <td>${UserBig.getLogoutTime()}</td>
            <td>${UserBig.getIp()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
