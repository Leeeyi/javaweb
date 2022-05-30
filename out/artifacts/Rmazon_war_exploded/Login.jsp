<%--
  Created by IntelliJ IDEA.
  User: 17567
  Date: 2021/10/30
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rmazon</title>
    <style>
        h1{text-align: center}
        div{text-align: center}
        #re{text-align: center}
    </style>
</head>
<body>
<div id="re">
    <form action="${pageContext.request.contextPath}/login" method="post">
        <table cellpadding="2" align="center">
            <tr>
                <!-- 输入用户名 -->
                <td align="right">用户:</td>
                <td><input type="text" name="name" /></td>
            </tr>
            <tr>
                <!-- 输入密码 -->
                <td align="right">密码:</td>
                <td><input type="password" name="password" /></td>
            </tr>
        </table>
        <input type="submit" value="登录" />
    </form>
    没有账户?<a href="Register.jsp">注册</a>
</div>
</body>
</html>