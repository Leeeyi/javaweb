<%--
  Created by IntelliJ IDEA.
  User: 17567
  Date: 2021/12/24
  Time: 2:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rmazon</title>
    <style>
        div{text-align: center}
    </style>
</head>
<body>
<div>
    <br><br>
    <form action="${pageContext.request.contextPath}/info" method="post">
        收货人姓名：<input type="text" name="name"><br>
        收货人地址：<input type="text" name="address"><br>
        收货人电话：<input type="text" name="phone"><br>
        <input type="submit" value="提交" />
    </form>
</div>
</body>
</html>
