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
    <title>管理员页面</title>
</head>
<body>
    <div align="right">
        <a href="${pageContext.request.contextPath}/logout">注销</a>
    </div>
    <font size="5"> <div align="center">选择操作</div></font><br>
    <font size="4">
        <div align="center"><a href="${pageContext.request.contextPath}/a_salesmanlist">销售员业绩</a></div><br>
        <div align="center"><a href="${pageContext.request.contextPath}/BoardofDiffkinds.jsp">各类别商品销售情况</a></div><br>
        <div align="center"><a href="${pageContext.request.contextPath}/salesmanlist">销售人员账户</a></div>
    </font>
</body>
</html>
