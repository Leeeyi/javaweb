<%@ page import="Bean.Goods" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>订单页面</title>
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
</div>
<% int i=0;%>
<table class="table table-striped">
    <thead>
    <tr>
        <th>#</th>
        <th>收货人名称</th>
        <th>收货人地址</th>
        <th>收货人电话</th>
        <th>订单商品</th>
        <th> </th>

    </tr>
    </thead> <tbody>
<!--这里开始循环输出list对象中的信息-->
<c:forEach items="${order}" var="Order">
    <tr>
        <th scope="row"><%=++i %></th>
        <td>${Order.getName()}</td>
        <td>${Order.getAddress()}</td>
        <td>${Order.getPhone()}</td>
        <td>${Order.getGoodsName()}</td>
        <td><a href="${pageContext.request.contextPath}/delOrder?id=${Order.getId()}">订单已完成，删除</a> </td>

    </tr>
</c:forEach>

</tbody>
</table>
</body>
</html>
