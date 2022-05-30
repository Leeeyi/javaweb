<%--
  Created by IntelliJ IDEA.
  User: 17567
  Date: 2021/12/19
  Time: 23:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>销售员页面</title>
</head>
<body>
<div align="right">
    <a href="${pageContext.request.contextPath}/logout">注销</a>
</div>
<font size="5"> <div align="center">选择操作</div></font><br>
<font size="4">
    <div align="center"><a href="Admin_Goods.jsp">管理商品</a></div><br>
    <div align="center"><a href="${pageContext.request.contextPath}/browseorder">查看订单</a></div><br>
    <div align="center"><a href="${pageContext.request.contextPath}/salesmanboard">销售榜单</a></div><br>
</font>
</body>
</html>
