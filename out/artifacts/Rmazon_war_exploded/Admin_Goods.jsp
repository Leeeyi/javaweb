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
    <a href="${pageContext.request.contextPath}/SalesMan.jsp">主页</a>
    <a href="${pageContext.request.contextPath}/AddGoods.jsp">添加商品</a>
</div>
<% int i=0;%>
<table class="table table-striped">
    <thead>
    <tr>
        <th>#</th>
        <th>商品名称</th>
        <th>商品价格</th>
        <th>商品库存</th>
        <th>商品描述</th>
        <th>商品图片</th>
        <th> </th>
        <th> </th>

    </tr>
    </thead> <tbody>
<!--这里开始循环输出list对象中的信息-->
<c:forEach items="${list}" var="Goods">
    <tr>
        <th scope="row"><%=++i %></th>
        <td>${Goods.getName()}</td>
        <td>${Goods.getPrice()}</td>
        <td>${Goods.getNum()}</td>
        <td>${Goods.getDescription()}</td>
        <td><img src="/img/${Goods.getPicURL()}" width="160" height="160" border="0" style="CURSOR: hand"></td>
        <td><a href="${pageContext.request.contextPath}/delgoods?id=${Goods.getId()}">删除商品</a></td>
        <td><a href="${pageContext.request.contextPath}/change?id=${Goods.getId()}">修改商品</a></td>
    </tr>
</c:forEach>

</tbody>
</table>
</body>
</html>
