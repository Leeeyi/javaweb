<%--
  Created by IntelliJ IDEA.
  User: 17567
  Date: 2022/5/18
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="right">
    <a href="${pageContext.request.contextPath}/Admin.jsp">主页</a>
</div>
<font size="5"> <div align="center">选择要查看的商品种类的销量</div></font><br>
<div align="center"><a href="${pageContext.request.contextPath}/boardofdiffkinds?kind=1">电子产品</a></div><br>
<div align="center"><a href="${pageContext.request.contextPath}/boardofdiffkinds?kind=2">服装</a></div><br>
<div align="center"><a href="${pageContext.request.contextPath}/boardofdiffkinds?kind=3">食品/饮品</a></div><br>
<div align="center"><a href="${pageContext.request.contextPath}/boardofdiffkinds?kind=4">化妆品</a></div><br>
<div align="center"><a href="${pageContext.request.contextPath}/boardofdiffkinds?kind=5">文具</a></div><br>
<div align="center"><a href="${pageContext.request.contextPath}/boardofdiffkinds?kind=6">日用品</a></div><br>
<div align="center"><a href="${pageContext.request.contextPath}/boardofdiffkinds?kind=7">图书</a></div><br>
<div align="center"><a href="${pageContext.request.contextPath}/boardofdiffkinds?kind=8">办公</a></div><br>
<div align="center"><a href="${pageContext.request.contextPath}/boardofdiffkinds?kind=9">乐器</a></div><br>
<div align="center"><a href="${pageContext.request.contextPath}/boardofdiffkinds?kind=10">其他</a></div><br><br><br>
<div align="center"><a href="${pageContext.request.contextPath}/board">商品总榜单</a></div><br>

</body>
</html>
