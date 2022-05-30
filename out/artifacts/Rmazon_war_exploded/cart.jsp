<%@ page import="Bean.Goods" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>购物车</title>
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
    </style>
</head>
<body>
<div align="right">
    <a href="Browse.jsp">主页</a>
</div>
<% int i=0;%>
<div align="center"> 您购物车中的商品如下 </div>
<table class="table table-striped">
    <thead>
    <tr>
        <th>商品名称</th>
        <th>商品价格</th>
        <th> </th>

    </tr>
    </thead> <tbody>
<tbody>
<c:forEach items="${cart}" var="Goods">

    <tr>
        <td>${Goods.getName()}</td>
        <td>${Goods.getPrice()}</td>
        <td><a href="${pageContext.request.contextPath}/delcart?id=${Goods.getId()}">删除</a></td>
    </tr>

</c:forEach>

</tbody>
</table>
<div align="center"><a href="${pageContext.request.contextPath}/Info.jsp">确认付款</a></div>
</body>
</html>
