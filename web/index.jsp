<%@ page import="Bean.Goods" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Rmazon</title>
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
<% int i=0;%>
<div>
    <a href="${pageContext.request.contextPath}/Login.jsp">登录</a>
    <a href="Register.jsp">注册</a>
</div>
<table class="table table-striped">
    <thead>
    <tr>
        <th>#</th>
        <th>商品名称</th>
        <th>商品价格</th>
        <th>商品库存</th>
        <th>商品描述</th>
        <th>商品图片</th>

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

    </tr>
</c:forEach>

</tbody>
</table>

</body>
</html>
