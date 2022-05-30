<%@ page import="Bean.Goods" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>管理页面</title>
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
</head>
<body>
<div>
    <a href="${pageContext.request.contextPath}/Admin.jsp">主页</a>
    <a href="${pageContext.request.contextPath}/AddSalesMan.jsp">添加销售人员</a>
</div>
<% int i=0;%>
<table class="table table-striped">
    <thead>
    <tr>
        <th>#</th>
        <th>销售人员ID </th>
        <th>密码</th>
        <th> </th>
        <th> </th>

    </tr>
    </thead> <tbody>
<!--这里开始循环输出list对象中的信息-->
<c:forEach items="${salesmanlist}" var="User">
    <tr>
        <th scope="row"><%=++i %></th>
        <td>${User.getName()}</td>
        <td>${User.getPassword()}</td>
        <td><a href="${pageContext.request.contextPath}/delsalesman?id=${User.getId()}">删除账户</a></td>
        <td><a href="${pageContext.request.contextPath}/changesalesman?id=${User.getId()}">修改密码</a></td>
    </tr>
</c:forEach>

</tbody>
</table>
</body>
</html>
