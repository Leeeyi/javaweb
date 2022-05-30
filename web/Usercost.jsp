<%--
  Created by IntelliJ IDEA.
  User: 17567
  Date: 2022/5/26
  Time: 13:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        width: 50px;
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
    <a href="${pageContext.request.contextPath}/ClientList_cost.jsp">返回</a>
</div>
<h2 align="center">如下为用户${clientname}的购物喜好（各种类商品购物金额）</h2><br/>
<table>
    <thead>
    <tr>
        <th></th>
        <th>电子产品</th>
        <th>服装</th>
        <th>食品/饮品</th>
        <th>化妆品</th>
        <th>文具</th>
    </tr>
    </thead>
    <tr>
        <th>消费金额</th>
        <th>${sessionScope.cost.getEle()}</th>
        <th>${sessionScope.cost.getCloth()}</th>
        <th>${sessionScope.cost.getFood()}</th>
        <th>${sessionScope.cost.getCosmetic()}</th>
        <th>${sessionScope.cost.getStationery()}</th>
    </tr>
    <tr>
        <th>占比</th>
        <th>${sessionScope.persona.getEle()}</th>
        <th>${sessionScope.persona.getCloth()}</th>
        <th>${sessionScope.persona.getFood()}</th>
        <th>${sessionScope.persona.getCosmetic()}</th>
        <th>${sessionScope.persona.getStationery()}</th>
    </tr>
</table>
<br/>
<table>
    <tr>
        <th></th>
        <th>日用品</th>
        <th>图书</th>
        <th>办公</th>
        <th>乐器</th>
        <th>其他</th>
    </tr>
    <tr>
        <th>消费金额</th>
        <th>${sessionScope.cost.getDaily()}</th>
        <th>${sessionScope.cost.getBook()}</th>
        <th>${sessionScope.cost.getOffice()}</th>
        <th>${sessionScope.cost.getMusical()}</th>
        <th>${sessionScope.cost.getOthers()}</th>
    </tr>
    <tr>
        <th>占比</th>
        <th>${sessionScope.persona.getDaily()}</th>
        <th>${sessionScope.persona.getBook()}</th>
        <th>${sessionScope.persona.getOffice()}</th>
        <th>${sessionScope.persona.getMusical()}</th>
        <th>${sessionScope.persona.getOthers()}</th>
    </tr>
</table>
</body>
</html>
