<%@ page import="Bean.Goods" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>销售榜单</title>
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
<div>
    <a href="${pageContext.request.contextPath}/SalesManList.jsp">返回</a>
</div>
<h2 align="center">销售员${salesmanname}的销售业绩如下</h2>
<% int i=0;%>
<table class="table table-striped">
    <thead>
    <tr>
        <th>#</th>
        <th>商品编号</th>
        <th>商品名称</th>
        <th>商品销量</th>

    </tr>
    </thead> <tbody>
<!--这里开始循环输出list对象中的信息-->
<c:forEach items="${board}" var="Goods">
<tr>
    <th scope="row"> </th>
    <td>${Goods.getId()}</td>
    <td>${Goods.getName()}</td>
    <td>${Goods.getSellnum()}</td>

</tr>
</c:forEach>
    <thead>
    <tr>
        <th>总销量</th>
        <th></th>
        <th></th>
        <th>${sum}</th>

    </tr>
    </thead> <tbody>

</tbody>
</table>

</body>
</html>
