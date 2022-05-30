<%--
  Created by IntelliJ IDEA.
  User: 17567
  Date: 2021/12/20
  Time: 1:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        div{text-align: center}
    </style>
</head>
<body>
<form action="${pageContext.request.contextPath}/addsalesman" method="post">
    <table cellpadding="2" align="center">
        <tr>
            <td align="right">用户ID</td>
            <td>
                <!-- 1.文本输入框控件 -->
                <input type="text" name="name" />
            </td>
        </tr>
        <tr>
            <td align="right">&nbsp;&nbsp;&nbsp;用户密码</td>
            <td>
                <!-- 1.文本输入框控件 -->
                <input type="text" name="password" />
            </td>
        </tr>
        <tr>
            <td colspan="2"  align="center">
                <!-- 6.提交按钮控件 -->
                <input type="submit" value="提交" />
                <a href="AdminSalesMan.jsp"><input type="button" value="取消" /></a>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
