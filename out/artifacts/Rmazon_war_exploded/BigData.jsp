<%--
  Created by IntelliJ IDEA.
  User: 17567
  Date: 2022/5/26
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>大数据管理页面</title>
</head>
<body>
    <div align="right">
        <a href="${pageContext.request.contextPath}/logout">注销</a>
    </div>
    <font size="5"> <div align="center">选择操作</div></font><br>
    <font size="4">
        <div align="center"><a href="${pageContext.request.contextPath}/logtime">各用户登录登出时间</a></div><br>
        <div align="center"><a href="${pageContext.request.contextPath}/clientlist?role=0">各用户商品喜好统计</a></div><br>
        <div align="center"><a href="${pageContext.request.contextPath}/clientlist?role=1">各用户对不同种类商品支出的统计</a></div>
    </font>
</body>
</html>
